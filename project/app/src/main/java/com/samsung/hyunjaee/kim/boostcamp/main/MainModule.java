package com.samsung.hyunjaee.kim.boostcamp.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
@SuppressWarnings("unused")
public interface MainModule {

    @ContributesAndroidInjector
    MainFragment contributeMainFragment();
}