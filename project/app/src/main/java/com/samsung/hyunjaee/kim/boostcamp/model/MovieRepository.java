package com.samsung.hyunjaee.kim.boostcamp.model;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import java.util.List;

interface MovieRepository {

    List<Movie> getMovies(String title);
}
