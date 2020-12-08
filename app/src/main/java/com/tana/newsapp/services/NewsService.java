package com.tana.newsapp.services;


import com.tana.newsapp.model.RecentlyHeadlines;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {
    @GET("/v2/top-headlines?sources=bbc-news&apiKey=bc819b34e3c744f286872377f249fa7c")
    Call<ArrayList<RecentlyHeadlines>> geHeadlines();
}
