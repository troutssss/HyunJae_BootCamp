package com.samsung.hyunjaee.kim.boostcamp;

import android.app.Application;

import timber.log.Timber;

public class BoostCampApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
