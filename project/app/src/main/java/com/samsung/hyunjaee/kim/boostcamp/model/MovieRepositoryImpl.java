package com.samsung.hyunjaee.kim.boostcamp.model;

import androidx.lifecycle.LiveData;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.MovieDao;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.MovieApi;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.entity.MovieDto;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieDao mMovieDao;
    private MovieApi mMovieApi;

    @Inject
    MovieRepositoryImpl(MovieDao movieDao, MovieApi movieApi) {
        mMovieApi = movieApi;
        mMovieDao = movieDao;
    }

    @Override
    public Single<List<Movie>> findMovie(String title) {
        return mMovieApi.findMovies(title)
                .flatMap(remoteList ->
                        Single.fromCallable(() -> convertMovieList(remoteList)))
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

    private List<Movie> convertMovieList(List<MovieDto> remoteList) {
        return remoteList.stream()
                .map(movieDto -> {
                    Movie movie = new Movie(movieDto.getTitle());
                    movie.setTitle(movieDto.getTitle());
                    return movie;
                })
                .collect(Collectors.toList());
    }

}
