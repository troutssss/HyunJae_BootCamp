package com.samsung.hyunjaee.kim.boostcamp;

import com.samsung.hyunjaee.kim.boostcamp.di.ViewModelModule;
import com.samsung.hyunjaee.kim.boostcamp.main.MainModule;
import com.samsung.hyunjaee.kim.boostcamp.model.RepositoryModule;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.LocalDataSourceModule;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.RemoteDataSourceModule;
import com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.naver.NaverMovieModule;

import dagger.Module;

@Module(includes = {
        RepositoryModule.class,
        LocalDataSourceModule.class,
        RemoteDataSourceModule.class,
        NaverMovieModule.class,
        ViewModelModule.class,
        MainModule.class
})
interface AppModule {

}