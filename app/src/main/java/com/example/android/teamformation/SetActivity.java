package com.example.android.teamformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;

public class SetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
    }

    public void setEmail(View view) {

        EditText emailText = (EditText) findViewById(R.id.resetEmail);
        ParseUser user = ParseUser.getCurrentUser();
        user.put("email", emailText.getText().toString());
        user.saveInBackground();

    }

    public void setName(View view) {
        EditText nameText = (EditText) findViewById(R.id.resetName);
        ParseUser user = ParseUser.getCurrentUser();
        user.setUsername(nameText.getText().toString());
    }

    public void done(View view) {
        finish();
    }

}
