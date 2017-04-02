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
    ParseUser user;
    EditText emailText;
    EditText skillText;
    EditText ideaText;
    EditText overviewText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        final Context context = getApplicationContext();
        Button button = (Button) findViewById(R.id.SignUpButton);

        user = ParseUser.getCurrentUser();
        emailText = (EditText) findViewById(R.id.email);
        skillText = (EditText) findViewById(R.id.skill);
        ideaText = (EditText) findViewById(R.id.idea);
        overviewText = (EditText) findViewById(R.id.overview);

        Toast toast = Toast.
                makeText(context, user.getEmail().toString(), Toast.LENGTH_SHORT);
        toast.show();
        emailText.setText(user.getEmail().toString(), TextView.BufferType.EDITABLE);
    }

    public void post(View view) {
        ParseObject postObject = new ParseObject("Post");
        postObject.put("user", user.getUsername());
        postObject.put("email", emailText.getText().toString());
        postObject.put("skill", skillText.getText().toString());
        postObject.put("content", ideaText.getText().toString());
        postObject.put("overview", overviewText.getText().toString());

        postObject.saveInBackground();

        setResult(RESULT_OK, null);
        finish();
    }
}
