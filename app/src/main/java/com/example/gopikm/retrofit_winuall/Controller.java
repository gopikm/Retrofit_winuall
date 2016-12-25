package com.example.gopikm.retrofit_winuall;

import android.app.Application;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration;

/**
 * Created by gopikm on 25/12/16.
 */

public class Controller  extends Application {

    private static Controller instance;
    private JobManager jobManager;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        configureJobManager();
    }

    public static synchronized Controller getInstance(){
        if(instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public JobManager getJobManager(){
        return jobManager;
    }

    private void configureJobManager() {
        Configuration.Builder builder = new Configuration.Builder(this)
                .minConsumerCount(1)
                .maxConsumerCount(5)
                .loadFactor(5)
                .consumerKeepAlive(120);

        jobManager = new JobManager(builder.build());
    }
}

