package com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieInfo {

    @SerializedName("display")
    private int display;
    @SerializedName("items")
    private List<MovieDto> movieList;
    @SerializedName("lastBuildDate")
    private String lastBuildDate;
    @SerializedName("start")
    private int start;
    @SerializedName("total")
    private int total;

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public List<MovieDto> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieDto> movieList) {
        this.movieList = movieList;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
