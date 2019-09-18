package com.samsung.hyunjaee.kim.boostcamp.model.datasource.local.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "movies")
public class Movie {

    @Ignore
    private static final String UNKNOWN_ID = "unknown";

    @PrimaryKey
    @NonNull
    private String id = UNKNOWN_ID;
    private String title;
    private String director;
    private long date;

    public Movie(String id) {
        setId(id);
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
