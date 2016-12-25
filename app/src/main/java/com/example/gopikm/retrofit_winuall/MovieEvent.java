package com.example.gopikm.retrofit_winuall;

/**
 * Created by gopikm on 25/12/16.
 */

public class MovieEvent {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieEvent(String name) {
        this.name = name;
    }

    private String name;
}
