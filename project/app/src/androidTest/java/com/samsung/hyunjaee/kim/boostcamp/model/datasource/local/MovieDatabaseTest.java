package com.samsung.hyunjaee.kim.boostcamp.model.datasource.local;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MovieDatabaseTest {

    private MovieDatabase db;
    private MovieDao movieDao;

    @Before
    public void setup() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, MovieDatabase.class).build();
        movieDao = db.movieDao();
    }

    @After
    public void clean() {
        db.close();
    }

    @Test
    public void Should_ReturnSameDb_When_getInstanceIsCalled() {
        Context context = ApplicationProvider.getApplicationContext();
        MovieDatabase database = MovieDatabase.getDatabase(context);
        assertThat(database, is(MovieDatabase.getDatabase(context)));
    }

    @Test
    public void Should_GetMovie_When_InsertMovieToDB() {
        String id = "movie_id";
        long date = 1231231L;
        String title = "title";
        Movie movie = new Movie(id);
        movie.setDate(date);
        movie.setTitle(title);

        movieDao.insertMovie(movie);

        List<Movie> movieList = movieDao.getAllMovies();
        assertThat(movieList.size(), is(1));
        assertThat(movieList.get(0).getDate(), equalTo(date));

        movieList = movieDao.findMovieById(id);
        assertThat(movieList.size(), is(1));
        assertThat(movieList.get(0).getDate(), equalTo(date));

    }

    @Test
    public void Should_GetMovie_When_FindByTitle() {
        String id = "id";
        long date = 0L;
        String title = "title";
        Movie movie = new Movie(id);
        movie.setDate(date);
        movie.setTitle(title);
        movieDao.insertMovie(movie);

        List<Movie> movieList = movieDao.getAllMovies();
        assertThat(movieList.size(), is(1));
        assertThat(movieList.get(0).getDate(), equalTo(date));

        movieList = movieDao.findMovieByTitle(title);
        assertThat(movieList.size(), is(1));
        assertThat(movieList.get(0).getDate(), equalTo(date));

        movieList = movieDao.findMovieByTitle("tit");
        assertThat(movieList.size(), is(1));
        assertThat(movieList.get(0).getDate(), equalTo(date));

    }
}
