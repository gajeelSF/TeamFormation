package com.example.android.teamformation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.*;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment {

    ArrayList<Post> arrayOfPosts = new ArrayList<>();

    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
//        query.whereEqualTo("playerName", "Dan Stemkoski");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> postList, ParseException e) {
                if (e == null) {
                    Toast login = Toast.makeText(getContext(),
                            "Retrieved " + postList.size(), Toast.LENGTH_SHORT);
                    login.show();

                    // attach the adapter to the listview
                    for (ParseObject i : postList) {
                        Post newPost = new Post(i);
                        arrayOfPosts.add(newPost);
                    }
                    PostAdapter postAdapter = new PostAdapter(getContext(), arrayOfPosts);
                    ListView listView = (ListView) getView().findViewById(R.id.timeline);
                    listView.setAdapter(postAdapter);


                } else {
                    Toast login = Toast.makeText(getContext(),
                            e.getLocalizedMessage(), Toast.LENGTH_SHORT);
                    login.show();
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timeline, container, false);
    }




}
