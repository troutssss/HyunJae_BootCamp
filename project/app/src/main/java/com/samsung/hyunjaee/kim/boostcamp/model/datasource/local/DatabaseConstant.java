package com.samsung.hyunjaee.kim.boostcamp.model.datasource.local;

class DatabaseConstant {

    private static final String TAG = "DatabaseConstant";

    private DatabaseConstant() {
        throw new IllegalAccessError(TAG);
    }

    // Constants
    static final String DATABASE_NAME = "movie_database";
    static final int VERSION = 1;
}
