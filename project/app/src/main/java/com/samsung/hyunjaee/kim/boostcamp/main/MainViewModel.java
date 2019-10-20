package com.samsung.hyunjaee.kim.boostcamp.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.samsung.hyunjaee.kim.boostcamp.model.MovieRepository;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<Movie>> mMovieList = new MutableLiveData<>();
    private MutableLiveData<String> mQuery = new MutableLiveData<>();

    MovieRepository mMovieRepository;

    private CompositeDisposable mDisposable = new CompositeDisposable();

    @Inject
    MainViewModel(@NonNull Application application, MovieRepository movieRepository) {
        super(application);
        Timber.d("MainViewModel()");
        mMovieRepository = movieRepository;
        findMovies("Captain Marvel");
    }

    public void findMovies(String title) {
        mDisposable.add(mMovieRepository.findMovie(title)
                .subscribe(movieList -> mMovieList.postValue(movieList), throwable -> Timber.e(throwable)));
    }

    LiveData<List<Movie>> getMovieList() {
        return mMovieList;
    }

    public MutableLiveData<String> getQuery() {
        return mQuery;
    }

    public void setQuery(MutableLiveData<String> mQuery) {
        this.mQuery = mQuery;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Timber.d("onCleared");
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }

    }
}
