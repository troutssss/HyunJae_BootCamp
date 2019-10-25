package com.samsung.hyunjaee.kim.boostcamp;

import com.samsung.hyunjaee.kim.boostcamp.model.MovieRepository;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Inject;

public class MovieRepositoryTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Inject
    MovieRepository mMovieRepository;


    @Test
    public void Should_AddMovie_When_InsertDummyMovie() {
        // todo :: Apply Dagger2 and create mock object for this test.
    }

}
