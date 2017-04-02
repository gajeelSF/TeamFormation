package com.example.android.teamformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        post = bundle.getParcelable("com.example.android.teamformation.Post");

        TextView overview = (TextView) findViewById(R.id.overviewtext);
        TextView skill = (TextView) findViewById(R.id.skilltext);
        TextView contact = (TextView) findViewById(R.id.contacttext);

        overview.setText(post.overview);
        skill.setText(post.skill);
        contact.setText(post.email);

        Button delete = (Button) findViewById(R.id.deleteButton);
        ParseUser currentUser = ParseUser.getCurrentUser();
        if(!currentUser.getUsername().equals(post.user)) {
            delete.setVisibility(View.GONE);
        }
    }

    public void deleteClicked(View view) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
        query.getInBackground(post.id, new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    object.deleteInBackground();
                    finish();
                } else {
                    // something went wrong
                }
            }
        });
    }
}
