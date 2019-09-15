package com.apps.rizkiadam.latihanmvp.presenter;

import com.apps.rizkiadam.latihanmvp.model.FilmModel;

public interface MainPresenter {
    void save(FilmModel film);

    void update(FilmModel film);

    void delete(FilmModel film);

    void load();

}
