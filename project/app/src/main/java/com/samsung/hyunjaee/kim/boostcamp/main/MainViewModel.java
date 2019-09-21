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

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
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
        Completable.create(emitter -> {
            Long currentTime = SystemClock.currentThreadTimeMillis();
            Movie movie = new Movie(currentTime + "");
            movie.setTitle("title");
            mMovieRepository.addMovie(movie);
            emitter.onComplete();
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Timber.d("onAdd"))
                .isDisposed();
    }

    public LiveData<List<Movie>> getMovieList() {
        return mMovieList;
    }
}
