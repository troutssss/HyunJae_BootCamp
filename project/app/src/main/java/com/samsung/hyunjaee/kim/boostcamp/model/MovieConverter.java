package com.samsung.hyunjaee.kim.boostcamp.model;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.entity.MovieDto;

import java.util.List;
import java.util.stream.Collectors;

class MovieConverter {

    Movie convert(MovieDto movieDto) {
        Movie movie = new Movie(movieDto.getTitle().hashCode() + "");
        movie.setTitle(movieDto.getTitle());
        movie.setDirector(movieDto.getDirector());
        return movie;
    }


    List<Movie> convertList(List<MovieDto> remoteList) {
        return remoteList.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

}
