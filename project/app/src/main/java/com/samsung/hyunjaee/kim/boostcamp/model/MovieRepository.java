package com.samsung.hyunjaee.kim.boostcamp.model;

import androidx.lifecycle.LiveData;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> getMovies(String title);

    LiveData<List<Movie>> getAllMovies();

    void addMovie(Movie movie);
}
