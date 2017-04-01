package com.example.android.teamformation;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by jiazhengzhao on 4/1/17.
 */

public class TeamFormation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("teamfor")
                .server("http://teamfor.herokuapp.com/parse/")
                .build()
        );

    }
}
