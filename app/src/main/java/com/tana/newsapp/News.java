package com.tana.newsapp;

public class News {
    private String mNewsHeader;
    private String mDate;
    private int mNewsImg;
    private String mCatTitle;
    private int mCatImg;

    public News(String catTitle, int catImg) {
        mCatTitle = catTitle;
        mCatImg = catImg;
    }

    public News(String newsHeader, String date, int newsImg) {
        mNewsHeader = newsHeader;
        mDate = date;
        mNewsImg = newsImg;
    }

    public String getNewsHeader() {
        return mNewsHeader;
    }

    public void setNewsHeader(String newsHeader) {
        mNewsHeader = newsHeader;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public int getNewsImg() {
        return mNewsImg;
    }

    public void setNewsImg(int newsImg) {
        mNewsImg = newsImg;
    }

    public String getCatTitle() {
        return mCatTitle;
    }

    public void setCatTitle(String catTitle) {
        mCatTitle = catTitle;
    }

    public int getCatImg() {
        return mCatImg;
    }

    public void setCatImg(int catImg) {
        mCatImg = catImg;
    }
}
