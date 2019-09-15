package com.apps.rizkiadam.latihanmvp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.rizkiadam.latihanmvp.R;
import com.apps.rizkiadam.latihanmvp.model.FilmModel;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private List<FilmModel> films;
    private OnCallbackListener listener;

    public MainRecyclerAdapter(List<FilmModel> films) {
        this.films = films;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_film, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FilmModel film = films.get(position);
        holder.textViewNama.setText(film.getNamaFilm());
        holder.textViewGenre.setText(film.getGenreFilm());
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public void setOnCallbackListener(OnCallbackListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewNama;
        TextView textViewGenre;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewNama = itemView.findViewById(R.id.nama);
            textViewGenre = itemView.findViewById(R.id.genre);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(films.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {

        void onClick(FilmModel user);
    }
}