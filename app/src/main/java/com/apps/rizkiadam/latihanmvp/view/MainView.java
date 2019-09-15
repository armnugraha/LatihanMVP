package com.apps.rizkiadam.latihanmvp.view;

import com.apps.rizkiadam.latihanmvp.model.FilmModel;

import java.util.List;

public interface MainView {

    void onLoad(List<FilmModel> film);

    void onSave();

    void onDelete();

    void onUpdate();
}
