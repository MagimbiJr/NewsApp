package com.tana.newsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModal {
    @SerializedName("status")
    private String status;
    @SerializedName("totalResult")
    private int totalResult;
    @SerializedName("articles")
    private List<RecentlyHeadlines> articles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public List<RecentlyHeadlines> getArticles() {
        return articles;
    }

    public void setArticles(List<RecentlyHeadlines> articles) {
        this.articles = articles;
    }
}
