package com.example.android.teamformation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> postList, ParseException e) {
                if (e == null) {
                    Toast login = Toast.makeText(getContext(),
                            "Retrieved " + postList.size(), Toast.LENGTH_SHORT);
                    login.show();

                    // attach the adapter to the listview
                    for (int i = postList.size() - 1; i >= 0; i--) {
                        Post newPost = new Post(postList.get(i));
                        arrayOfPosts.add(newPost);
                    }
                    PostAdapter postAdapter = new PostAdapter(getContext(), arrayOfPosts);
                    ListView listView = (ListView) getView().findViewById(R.id.timeline);
                    listView.setAdapter(postAdapter);

                    // add action listener.
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> a,
                                                View v, int position, long id) {
                            Post post = (Post) a.getItemAtPosition(position);
                            Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                            intent.putExtra("com.example.android.teamformation.Post", post);
                            startActivity(intent);
                        }
                    });


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
