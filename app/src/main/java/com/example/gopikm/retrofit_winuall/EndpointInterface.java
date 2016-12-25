package com.example.gopikm.retrofit_winuall;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gopikm on 25/12/16.
 */

public interface EndpointInterface {

    @GET(".")
    Call<Movie> getMovie(@Query("i") String id);
}
