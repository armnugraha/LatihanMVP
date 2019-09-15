package com.apps.rizkiadam.latihanmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.rizkiadam.latihanmvp.adapter.MainRecyclerAdapter;
import com.apps.rizkiadam.latihanmvp.model.FilmModel;
import com.apps.rizkiadam.latihanmvp.presenter.MainPresenter;
import com.apps.rizkiadam.latihanmvp.presenter.MainPresenterImpl;
import com.apps.rizkiadam.latihanmvp.view.MainView;

import java.util.ArrayList;
import java.util.List;

/*
Developed by RizkiAdamKurniawan
on Sunday, March 31 2019
*/


public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView recyclerView;
    private Button buttonAdd;
    private MainRecyclerAdapter adapter;
    private List<FilmModel> filmList = new ArrayList<>();
    private AppCompatDialog dialog;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MainRecyclerAdapter(filmList);

        adapter.setOnCallbackListener(new MainRecyclerAdapter.OnCallbackListener() {
            @Override
            public void onClick(FilmModel film) {
                showDialogUpdate(film);
            }
        });

        recyclerView.setAdapter(adapter);

        buttonAdd = findViewById(R.id.btn_main_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogInput();
            }
        });

        presenter.load();
    }

    @Override
    public void onLoad(List<FilmModel> films) {
        filmList.clear();
        filmList.addAll(films);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSave() {
        Toast.makeText(this, "Berhasil disimpan!", Toast.LENGTH_SHORT).show();
        presenter.load();
    }

    @Override
    public void onDelete() {
        Toast.makeText(this, "Berhasil dihapus!", Toast.LENGTH_SHORT).show();
        presenter.load();
    }

    @Override
    public void onUpdate() {
        Toast.makeText(this, "Berhasil diperbarui!", Toast.LENGTH_SHORT).show();
        presenter.load();
    }

    public void showDialogInput() {
        dialog = new AppCompatDialog(this);
        dialog.setContentView(R.layout.dialog_input);
        dialog.setTitle("Tambah Data Film");

        final EditText edtName = dialog.findViewById(R.id.edt_di_nama);
        final EditText edtGenre = dialog.findViewById(R.id.edt_di_genre);
        final EditText edtDurasi = dialog.findViewById(R.id.edt_di_durasi);
        final EditText edtRating = dialog.findViewById(R.id.edt_di_rating);

        Button buttonSave = dialog.findViewById(R.id.btn_di_simpan);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilmModel film = new FilmModel();
                film.setNamaFilm(edtName.getText().toString());
                film.setGenreFilm(edtGenre.getText().toString());
                film.setDurasiFilm(edtDurasi.getText().toString());
                film.setRatingFilm(edtRating.getText().toString());
                presenter.save(film);
                dialog.dismiss();
            }
        });

        Button buttonCancel = dialog.findViewById(R.id.btn_di_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    public void showDialogUpdate(final FilmModel film) {
        dialog = new AppCompatDialog(this);
        dialog.setContentView(R.layout.dialog_input);
        dialog.setTitle("Update Data Film");

        final EditText edtDlName = dialog.findViewById(R.id.edt_di_nama);
        final EditText edtDlGenre = dialog.findViewById(R.id.edt_di_genre);
        final EditText edtDlDurasi = dialog.findViewById(R.id.edt_di_durasi);
        final EditText edtDlRating = dialog.findViewById(R.id.edt_di_rating);

        edtDlName.setText(film.getNamaFilm());
        edtDlGenre.setText(film.getGenreFilm());
        edtDlDurasi.setText(film.getDurasiFilm());
        edtDlRating.setText(film.getRatingFilm());

        Button buttonUpdate = dialog.findViewById(R.id.btn_di_simpan);
        buttonUpdate.setText("Update");
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                film.setNamaFilm(edtDlName.getText().toString());
                film.setGenreFilm(edtDlGenre.getText().toString());
                film.setDurasiFilm(edtDlDurasi.getText().toString());
                film.setRatingFilm(edtDlRating.getText().toString());

                presenter.update(film);
                dialog.dismiss();
            }
        });

        Button buttonDelete = dialog.findViewById(R.id.btn_di_cancel);
        buttonDelete.setText("Delete");
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.delete(film);
                dialog.dismiss();
            }
        });

        if (!dialog.isShowing()) {
            dialog.show();
        }
    }
}
