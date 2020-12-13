package com.tana.newsapp.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    public static final String URL = "https://newsapi.org/v2/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
//    private static final Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL)
//            .addConverterFactory(GsonConverterFactory.create());
//
//    private static final Retrofit retrofit = builder.build();
//
//    public static <S> S builderService(Class<S> serviceType) {
//        return retrofit.create(serviceType);
//    }
}
