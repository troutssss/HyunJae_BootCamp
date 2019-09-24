package com.samsung.hyunjaee.kim.boostcamp.model;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.MovieRepositoryImpl;

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
}
