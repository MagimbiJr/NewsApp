package com.tana.newsapp.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    private static final String URL = "https://newsapi.org/";
    private static final Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = builder.build();

    public static <S> S builderService(Class<S> serviceType) {
        return retrofit.create(serviceType);
    }
}
