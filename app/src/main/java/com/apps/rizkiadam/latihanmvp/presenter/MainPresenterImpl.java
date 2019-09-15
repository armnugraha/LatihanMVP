package com.apps.rizkiadam.latihanmvp.presenter;

import com.apps.rizkiadam.latihanmvp.model.FilmModel;
import com.apps.rizkiadam.latihanmvp.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    private List<FilmModel> films = new ArrayList<>();
    private int no = 4;

    public MainPresenterImpl(MainView mainView){
        this.mainView = mainView;
        setData();
    }

    private void setData() {
        FilmModel film = new FilmModel();
        film.setId(1);
        film.setNamaFilm("Avenger : EndGame");
        film.setGenreFilm("Action, Adveture, Fantasy");
        film.setDurasiFilm("181 Minutes");
        film.setRatingFilm("R");
        films.add(film);

        FilmModel film1 = new FilmModel();
        film1.setId(2);
        film1.setNamaFilm("Shazam");
        film1.setGenreFilm("Action, Adveture, Fantasy");
        film1.setDurasiFilm("132 Minutes");
        film1.setRatingFilm("R 13+");
        films.add(film1);

        FilmModel film2 = new FilmModel();
        film2.setId(3);
        film2.setNamaFilm("Pet Sematary");
        film2.setGenreFilm("Horror, Thriller");
        film2.setDurasiFilm("101 Minutes");
        film2.setRatingFilm("D 17+");
        films.add(film2);
    }

     /*   FilmModel film3 = new FilmModel();
        film3.setId(4);
        film3.setNamaFilm("Five Feet Apart");
        film3.setGenreFilm("Drama, Romance");
        film3.setDurasiFilm("116 Minutes");
        film3.setRatingFilm("R 13+");
        films.add(film3);
    }*/


    @Override
    public void save(FilmModel film) {
        no++;
        film.setId(no);
        films.add(film);

        mainView.onSave();
    }

    @Override
    public void update(FilmModel film) {
        for (FilmModel model : films){
            if (model.getId() == film.getId()){
                model.setNamaFilm(film.getNamaFilm());
                model.setGenreFilm(film.getGenreFilm());
                model.setDurasiFilm(film.getDurasiFilm());
                model.setRatingFilm(film.getRatingFilm());

                break;
            }
        }

        mainView.onUpdate();
    }

    @Override
    public void delete(FilmModel film) {
        films.remove(film);

        mainView.onDelete();
    }

    @Override
    public void load() {
        mainView.onLoad(films);
    }
}
