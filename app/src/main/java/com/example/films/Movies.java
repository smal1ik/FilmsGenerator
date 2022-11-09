package com.example.films;

public class Movies {
    String film;
    Integer year;
    double ratingImdb;
    Integer filmLength;
    String country;
    boolean view = false;

    @Override
    public String toString() {
        return "Фильм: " + film + "\n" +
                "Год: " + year + "\n" +
                "Рейтинг IMDB: " + ratingImdb + "\n" +
                "Страна: " + country + "\n" +
                "Длительность: " + filmLength + " минут";
    }

    public String getFilm(){
        return film;
    }

    public String getYear(){
        return year.toString();
    }

    public boolean getView(){
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }
}
