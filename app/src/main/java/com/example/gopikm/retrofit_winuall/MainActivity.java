package com.example.gopikm.retrofit_winuall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.birbit.android.jobqueue.JobManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    TextView t;
    JobManager jobManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView) findViewById(R.id.text);

        EventBus.getDefault().register(this);

        jobManager = Controller.getInstance().getJobManager() ;
        jobManager.addJobInBackground(new MovieJob("job added"));
    }

    @Subscribe
    public void dothis(Movie event){
        t.setText(event.getTitle());
    }
}
