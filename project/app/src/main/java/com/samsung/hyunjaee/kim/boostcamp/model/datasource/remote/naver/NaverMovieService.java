package com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.naver;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.ApiConstant;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.entity.MovieInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

interface NaverMovieService {

    @Headers({
            "X-Naver-Client-Id: " + ApiConstant.CLIENT_ID,
            "X-Naver-Client-Secret: " + ApiConstant.CLIENT_SECRET
    })
    @GET("v1/search/movie.json")
    Call<MovieInfo> findMovies(@Query("query") String title);
}
