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

    }

    public void post(View view) {
        final Context context = getApplicationContext();
        Button button = (Button) findViewById(R.id.SignUpButton);

        EditText emailText = (EditText) findViewById(R.id.email);
        EditText skillText = (EditText) findViewById(R.id.skill);
        EditText ideaText = (EditText) findViewById(R.id.idea);

        System.out.println((String) emailText.getText().toString());
        System.out.println((String) skillText.getText().toString());
        System.out.println((String) ideaText.getText().toString());

        ParseObject postObject = new ParseObject("Post");
        postObject.put("email", emailText.getText().toString());
        postObject.put("skill", skillText.getText().toString());
        postObject.put("idea", ideaText.getText().toString());


        postObject.saveInBackground();



    }
}
