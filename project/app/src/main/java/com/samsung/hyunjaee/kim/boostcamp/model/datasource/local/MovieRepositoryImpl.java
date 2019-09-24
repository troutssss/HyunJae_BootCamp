package com.samsung.hyunjaee.kim.boostcamp.model.datasource.local;

import androidx.lifecycle.LiveData;

import com.samsung.hyunjaee.kim.boostcamp.model.MovieRepository;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieDao mMovieDao;

    @Inject
    MovieRepositoryImpl(MovieDao movieDao) {
        mMovieDao = movieDao;
    }

    @Override
    public List<Movie> getMovies(String title) {
        return mMovieDao.findMovieByTitle(title);
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
