package com.samsung.hyunjaee.kim.boostcamp.model.datasource.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.samsung.hyunjaee.kim.boostcamp.model.MovieRepository;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieDao mMovieDao;

    public MovieRepositoryImpl(Context context) {
        mMovieDao = MovieDatabase.getDatabase(context).movieDao();
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
    public void addMovie(Movie movie) {
        mMovieDao.insertMovie(movie);
    }
}
