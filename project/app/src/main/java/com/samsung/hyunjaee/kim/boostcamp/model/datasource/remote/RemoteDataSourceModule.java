package com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.naver.NaverMovieApi;

import dagger.Module;
import dagger.Provides;

@Module
public class RemoteDataSourceModule {
    private RemoteDataSourceModule() {

    }

    @Provides
    static MovieApi provideMovieApi(NaverMovieApi naverMovieApi) {
        return naverMovieApi;
    }

}