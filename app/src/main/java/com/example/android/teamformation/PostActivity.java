package com.example.android.teamformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.*;
import android.app.Application;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.duration;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
//        Parse.initialize(new Parse.Configuration.Builder(this)
//                .applicationId("teamfor")
//                .server("http://teamfor.herokuapp.com/parse/")
//                .build()
//        );
    }

    public void post(View view) {
        final Context context = getApplicationContext();
        Button button = (Button) findViewById(R.id.SignUpButton);

        EditText emailText = (EditText) findViewById(R.id.email);

        System.out.println((String) emailText.getText().toString());

        ParseObject testObject = new ParseObject("Post");
        testObject.put("content", emailText);
        testObject.saveInBackground();



    }
}
