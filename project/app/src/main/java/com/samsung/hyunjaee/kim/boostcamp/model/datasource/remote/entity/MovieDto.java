package com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.entity;

import com.google.gson.annotations.SerializedName;

public class MovieDto {

    @SerializedName("title")
    String title;
    @SerializedName("director")
    String director;
    @SerializedName("image")
    String imageURL;

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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
