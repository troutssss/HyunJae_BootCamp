package com.samsung.hyunjaee.kim.boostcamp.model.datasource.remote.entity;

import com.google.gson.annotations.SerializedName;

public class MovieDto {

    @SerializedName("title")
    String title;
    @SerializedName("director")
    String director;
    @SerializedName("image")
    String imageURL;
    @SerializedName("link")
    String linkURL;
    @SerializedName("subtitle")
    String engTitle;
    @SerializedName("actor")
    String actor;
    @SerializedName("userRating")
    float userRating;

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

    public String getLinkURL() {
        return linkURL;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }

    public String getEngTitle() {
        return engTitle;
    }

    public void setEngTitle(String engTitle) {
        this.engTitle = engTitle;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public float getUserRating() {
        return userRating;
    }

    public void setUserRating(float userRating) {
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return "title : " + title + "\n" +
                "director : " + director + "\n" +
                "imageURL : " + imageURL + "\n" +
                "linkURL : " + linkURL + "\n" +
                "engTitle : " + engTitle + "\n" +
                "actor : " + actor + "\n" +
                "userRating : " + userRating + "\n";
    }
}
