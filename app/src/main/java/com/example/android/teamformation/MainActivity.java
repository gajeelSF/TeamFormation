package com.example.android.teamformation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.*;
import android.app.Application;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("teamformation")
                .server("http://teamformation.herokuapp.com/lahackteam")
                .build()
        );
    }

    public void signUp(View view) {
        Context context = getApplicationContext();
        Button button = (Button) findViewById(R.id.SignUpButton);

        EditText usernameText = (EditText) findViewById(R.id.usernameText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);

        ParseUser user = new ParseUser();
        user.setUsername((String) usernameText.getText().toString());
        user.setPassword((String) passwordText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    System.out.println("Success!!!");
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    System.out.println(e.toString());
                }
            }
        });
    }


}
