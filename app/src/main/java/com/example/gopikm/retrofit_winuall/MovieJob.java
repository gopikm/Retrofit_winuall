package com.example.gopikm.retrofit_winuall;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gopikm on 25/12/16.
 */

public class MovieJob extends Job {

    public static final int PRIORITY = 1;

    public MovieJob(String params) {
        super(new Params(PRIORITY).requireNetwork().persist());
        Log.d("InJob",params);
    }

    @Override
    public void onAdded() {
        Log.d("In MovieJob","Added");

    }

    @Override
    public void onRun() throws Throwable {

        EndpointInterface endpoint=RetrofitBuilder.getClient().create(EndpointInterface.class);
        Call<Movie> call = endpoint.getMovie("tt2543164");
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });



    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}

