package com.example.gopikm.retrofit_winuall;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gopikm on 25/12/16.
 */

public class RetrofitBuilder {

    public static final String BASE_URL = "http://www.omdbapi.com/";

    public static Retrofit getClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
