package com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.entity.MovieDto;

import java.util.List;

import io.reactivex.Single;

public interface MovieApi {

    Single<List<MovieDto>> findMovies(String title);
}
