package com.example.android.teamformation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.*;

import android.app.Application;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void signUp(View view) {
        final Context context = getApplicationContext();
        Button button = (Button) findViewById(R.id.SignUpButton);

        EditText usernameText = (EditText) findViewById(R.id.usernameText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        EditText emailText = (EditText) findViewById(R.id.emailtext);

        ParseUser user = new ParseUser();
        user.setUsername(usernameText.getText().toString());
        user.setPassword(passwordText.getText().toString());
        user.setEmail(emailText.getText().toString());


        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    System.out.println("Success!!!");
                    Intent intent = new Intent(context, Home.class);
                    startActivity(intent);
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    System.out.println(e.toString());
                }
            }
        });
    }

    public void logIn(View view) {
        final Context context = getApplicationContext();
        Button button = (Button) findViewById(R.id.LogInButton);

        EditText usernameText = (EditText) findViewById(R.id.usernameText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);

        String username = (String) usernameText.getText().toString();
        String password = (String) passwordText.getText().toString();

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    // Hooray! The user is logged in.
                    Toast login = Toast.makeText(context, "LOGGED IN !!!", Toast.LENGTH_SHORT);
                    login.show();
                    Intent intent = new Intent(context, Home.class);
                    startActivity(intent);
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                    Toast login = Toast.makeText(context, "苟利国家生死以 岂因祸福避趋之\n\\口-口/", Toast.LENGTH_SHORT);
                    login.show();
                }
            }
        });
    }

}
