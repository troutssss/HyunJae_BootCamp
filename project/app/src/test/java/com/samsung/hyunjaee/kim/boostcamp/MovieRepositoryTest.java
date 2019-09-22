package com.samsung.hyunjaee.kim.boostcamp;

import android.content.Context;

import com.samsung.hyunjaee.kim.boostcamp.model.MovieRepository;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.MovieRepositoryImpl;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MovieRepositoryTest {

    @Mock
    Context mContext;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    MovieRepository mMovieRepository;

    @Before
    public void setup() {
        mMovieRepository = new MovieRepositoryImpl(mContext);
    }


    @Test
    public void Should_AddMovie_When_InsertDummyMovie() {

        mMovieRepository.addMovie(new Movie("asdf"));
        // todo :: Apply Dagger2 and create mock object for this test.
    }

}
