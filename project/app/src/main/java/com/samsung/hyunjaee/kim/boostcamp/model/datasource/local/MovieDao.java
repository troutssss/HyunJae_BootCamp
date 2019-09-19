package com.samsung.hyunjaee.kim.boostcamp.model.datasource.local;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public abstract class MovieDao {

    @Insert(onConflict = REPLACE)
    public abstract void insertMovie(Movie movie);

    @Insert(onConflict = REPLACE)
    public abstract void insertMovie(Movie... movie);

    @Query("Select * from movies")
    public abstract List<Movie> getAllMovies();

    @Query("Select * from movies")
    public abstract LiveData<List<Movie>> getMovies();

    @Query("Select * from movies where id =:id")
    public abstract List<Movie> findMovieById(String id);

    @Query("Select * from movies where title LIKE '%' || :title || '%'")
    public abstract List<Movie> findMovieByTitle(String title);

    @Delete
    public abstract void deleteMovie(Movie movie);

    @Update
    public abstract void updateMovie(Movie movie);

}
