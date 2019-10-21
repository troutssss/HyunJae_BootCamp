package com.samsung.hyunjaee.kim.boostcamp.model;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    private RepositoryModule() {

    }

    @Provides
    static MovieRepository provideMovieRepository(MovieRepositoryImpl movieRepository) {
        return movieRepository;
    }

    @Provides
    static MovieConverter provideMovieConverter() {
        return new MovieConverter();
    }
}
