package com.samsung.hyunjaee.kim.boostcamp.model.datasource.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity.Movie;

import timber.log.Timber;

@Database(entities = {Movie.class}, version = DatabaseConstant.VERSION)
public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();

    private static MovieDatabase sInstance;

    static MovieDatabase getDatabase(final Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MovieDatabase.class, DatabaseConstant.DATABASE_NAME)
                    .addCallback(new Callback() {
                        @Override
                        public void onOpen(@NonNull SupportSQLiteDatabase db) {
                            super.onOpen(db);
                            Timber.d("onOpen()");
                        }
                    })
                    .build();
        }
        return sInstance;
    }

}