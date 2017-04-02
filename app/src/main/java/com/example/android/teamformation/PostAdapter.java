package com.example.android.teamformation;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

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
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_post, parent, false);
        }
        // Lookup view for data population
        TextView tvSkill = (TextView) convertView.findViewById(R.id.skill);

        TextView tvContent = (TextView) convertView.findViewById(R.id.content);
        TextView tvUser = (TextView) convertView.findViewById(R.id.user);
        // Populate the data into the template view using the data object

        if(post.skill == null) {
            post.skill = "No Skill Required";
        }
        tvSkill.setText(post.skill);

        if(post.content == null) {
            post.content = "No content";
        }
        tvContent.setText(post.content);

        if(post.user == null ) {
            post.user = "Unknown User";
        }
        tvUser.setText(post.user);

        // Return the completed view to render on screen
        return convertView;
    }
}
