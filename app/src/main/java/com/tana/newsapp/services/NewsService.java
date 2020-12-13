package com.tana.newsapp.services;


import com.tana.newsapp.model.RecentlyHeadlines;
import com.tana.newsapp.model.ResponseModal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {
    @GET("top-headlines")
    Call<ResponseModal> geHeadlines(@Query("sources") String source,
                                    @Query("apiKey") String apiKey);

}
