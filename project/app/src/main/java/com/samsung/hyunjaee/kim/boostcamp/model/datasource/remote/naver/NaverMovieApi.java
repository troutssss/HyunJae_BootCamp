package com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.naver;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.MovieApi;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.entity.MovieDto;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.entity.MovieInfo;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class NaverMovieApi implements MovieApi {

    private NaverMovieService mNaverMovieService;

    @Inject
    public NaverMovieApi(NaverMovieService naverMovieService) {
        mNaverMovieService = naverMovieService;
    }

    @Override
    public Single<List<MovieDto>> findMovies(String title) {
        return Single.create(emitter -> {
            mNaverMovieService.findMovies(title).enqueue(new Callback<MovieInfo>() {
                @Override
                public void onResponse(@NotNull Call<MovieInfo> call, @NotNull Response<MovieInfo> response) {
                    Timber.d(response.toString());
                    if (response.body() != null) {
                        response.body().getMovieList().forEach(movieDto -> Timber.d(movieDto.getTitle()));
                        emitter.onSuccess(response.body().getMovieList());
                    } else {
                        emitter.onError(new Throwable("body is empty"));
                    }
                }

                @Override
                public void onFailure(@NotNull Call<MovieInfo> call, @NotNull Throwable t) {
                    emitter.onError(t);
                }
            });
        });
    }
}
