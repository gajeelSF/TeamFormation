package com.example.android.teamformation;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jiazhengzhao on 4/1/17.
 */

public class PostAdapter extends ArrayAdapter<Post> {
    public PostAdapter(Context context, List<Post> posts) {
        super(context, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Post post = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_timeline, parent, false);
        }
        // Lookup view for data population
        TextView tvSkill = (TextView) convertView.findViewById(R.id.skill);
        // Populate the data into the template view using the data object
        tvSkill.setText(post.skill);
        // Return the completed view to render on screen
        return convertView;
    }
}
