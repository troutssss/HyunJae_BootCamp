package com.samsung.hyunjaee.kim.boostcamp.main;

import android.app.Application;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.samsung.hyunjaee.kim.boostcamp.model.MovieRepository;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.MovieRepositoryImpl;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import java.util.List;

import timber.log.Timber;

public class MainViewModel extends AndroidViewModel {

    private LiveData<List<Movie>> mMovieList;
    private MovieRepository mMovieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        Timber.d("MainViewModel()");
        mMovieRepository = new MovieRepositoryImpl(getApplication());
        mMovieList = mMovieRepository.getAllMovies();
    }

    public void addDummyMovie() {
        long currentTime = SystemClock.currentThreadTimeMillis();
        Movie movie = new Movie(currentTime + "");
        movie.setTitle("title" + currentTime);
        mMovieRepository.addMovie(movie)
                .subscribe(() -> Timber.d("Add Movie complete"), Timber::e)
                .isDisposed();
    }

    public LiveData<List<Movie>> getMovieList() {
        return mMovieList;
    }
}