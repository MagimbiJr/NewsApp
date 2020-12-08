package com.tana.newsapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RecentlyHeadlines implements Serializable {
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("author")
    private String author;
    @SerializedName("date")
    private String date;

    public RecentlyHeadlines(String title, String description, String author, String date) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
