package com.samsung.hyunjaee.kim.boostcamp.model;

import androidx.lifecycle.LiveData;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import java.util.List;

import io.reactivex.Completable;

public interface MovieRepository {

    List<Movie> getMovies(String title);

    LiveData<List<Movie>> getAllMovies();

    Completable addMovie(Movie movie);
}
