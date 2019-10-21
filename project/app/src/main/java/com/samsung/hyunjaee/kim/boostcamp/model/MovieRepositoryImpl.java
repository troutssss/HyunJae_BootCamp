package com.samsung.hyunjaee.kim.boostcamp.model;

import androidx.lifecycle.LiveData;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.MovieDao;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.MovieApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieDao mMovieDao;
    private MovieApi mMovieApi;
    private MovieConverter mMovieConverter;

    @Inject
    MovieRepositoryImpl(MovieDao movieDao, MovieApi movieApi, MovieConverter movieConverter) {
        mMovieApi = movieApi;
        mMovieDao = movieDao;
        mMovieConverter = movieConverter;
    }

    @Override
    public Single<List<Movie>> findMovie(String title) {
        return mMovieApi.findMovies(title)
                .flatMap(remoteList ->
                        Single.fromCallable(() -> mMovieConverter.convertList(remoteList)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    @Override
    public LiveData<List<Movie>> getAllMovies() {
        return mMovieDao.getMovies();
    }

    @Override
    public Completable addMovie(Movie movie) {

        return Completable.create(emitter -> {
            mMovieDao.insertMovie(movie);
            emitter.onComplete();
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
