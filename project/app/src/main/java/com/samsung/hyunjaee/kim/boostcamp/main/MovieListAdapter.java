package com.samsung.hyunjaee.kim.boostcamp.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.samsung.hyunjaee.kim.boostcamp.databinding.MovieItemBinding;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import java.util.Collections;
import java.util.List;

import timber.log.Timber;

public class MovieListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MainViewModel mViewModel;
    private LifecycleOwner mLifecycleOwner;
    private List<Movie> mMovieList = Collections.emptyList();

    MovieListAdapter(@NonNull LifecycleOwner owner, @NonNull MainViewModel viewModel) {
        mLifecycleOwner = owner;
        mViewModel = viewModel;
        mViewModel.getMovieList().observe(mLifecycleOwner, this::submitList);
    }

    private void submitList(List<Movie> movieList) {
        Timber.d("submitList");
        movieList.forEach(movie -> Timber.d(movie.getTitle()));
        mMovieList = movieList;

        // todo :: implements DiffUtil for this.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MovieItemBinding binding = MovieItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new MovieItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieItemViewHolder viewHolder = (MovieItemViewHolder) holder;
        Movie movie = mMovieList.get(position);
        viewHolder.binding.movieTitle.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }


    class MovieItemViewHolder extends RecyclerView.ViewHolder {

        MovieItemBinding binding;

        MovieItemViewHolder(MovieItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
