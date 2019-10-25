package com.samsung.hyunjaee.kim.boostcamp.model;

import androidx.lifecycle.LiveData;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import java.util.List;

import io.reactivex.Single;

public interface MovieRepository {

    Single<List<Movie>> findMovie(String title);

    LiveData<List<Movie>> getAllMovies();
}
