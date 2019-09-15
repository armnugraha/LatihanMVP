package com.apps.rizkiadam.latihanmvp.model;

public class FilmModel {

    private int id;
    private String namaFilm;
    private String genreFilm;
    private String durasiFilm;
    private String ratingFilm;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNamaFilm() {
        return namaFilm;
    }
    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }
    public String getGenreFilm() {
        return genreFilm;
    }
    public void setGenreFilm(String genreFilm) {
        this.genreFilm = genreFilm;
    }
    public String getDurasiFilm() {
        return durasiFilm;
    }
    public void setDurasiFilm(String durasiFilm) {
        this.durasiFilm = durasiFilm;
    }
    public String getRatingFilm() {
        return ratingFilm;
    }
    public void setRatingFilm(String ratingFilm) {
        this.ratingFilm = ratingFilm;
    }
}
