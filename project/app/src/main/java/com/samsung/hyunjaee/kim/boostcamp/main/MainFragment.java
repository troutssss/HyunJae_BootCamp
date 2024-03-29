package com.samsung.hyunjaee.kim.boostcamp.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.samsung.hyunjaee.kim.boostcamp.R;
import com.samsung.hyunjaee.kim.boostcamp.databinding.FragmentMainBinding;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;

public class MainFragment extends Fragment {

    private FragmentMainBinding mBinding;
    private MainViewModel mViewModel;

    @Inject
    ViewModelProvider.Factory mFactory;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mViewModel = ViewModelProviders.of(this, mFactory).get(MainViewModel.class);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        mBinding.setLifecycleOwner(this);
        mBinding.setViewModel(mViewModel);

        MovieListAdapter movieListAdapter = new MovieListAdapter(this, mViewModel);
        mBinding.movieList.setAdapter(movieListAdapter);
        mBinding.movieList.setLayoutManager(new LinearLayoutManager(getContext()));
        mViewModel.getMovieList().observe(this, movieList -> movieList.forEach(movie -> {
            Timber.d(movie.getTitle());
        }));

        return mBinding.getRoot();
    }
}
