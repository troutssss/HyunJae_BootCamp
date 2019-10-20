package com.samsung.hyunjaee.kim.boostcamp.model.datasource.local;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalDataSourceModule {

    private LocalDataSourceModule() {

    }

    @Provides
    @Singleton
    static MovieDatabase provideDatabase(Application application) {
        return MovieDatabase.getDatabase(application);
    }

    @Provides
    static MovieDao provideMovieDao(MovieDatabase database) {
        return database.movieDao();
    }
}
