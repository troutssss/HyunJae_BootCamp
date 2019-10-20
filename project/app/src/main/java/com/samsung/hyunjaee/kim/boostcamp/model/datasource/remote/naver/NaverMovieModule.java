package com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.naver;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.ApiConstant;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NaverMovieModule {

    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ApiConstant.NAVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    static NaverMovieService provideNaverMovieService(Retrofit retrofit) {
        return retrofit.create(NaverMovieService.class);
    }
}
