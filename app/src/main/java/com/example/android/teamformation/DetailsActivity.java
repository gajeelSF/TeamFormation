package com.example.android.teamformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        Post post = bundle.getParcelable("com.example.android.teamformation");

        TextView overview = (TextView) findViewById(R.id.overviewtext);
        TextView skill = (TextView) findViewById(R.id.skilltext);
        TextView contact = (TextView) findViewById(R.id.contacttext);

        overview.setText(post.overview);
        skill.setText(post.skill);
        contact.setText(post.email);
    }
}
