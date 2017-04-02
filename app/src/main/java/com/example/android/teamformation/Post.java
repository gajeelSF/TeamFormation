package com.example.android.teamformation;

import android.os.Parcel;
import android.os.Parcelable;

import com.parse.ParseObject;

/**
 * Created by jiazhengzhao on 4/1/17.
 */

public class Post implements Parcelable {
    public String email;
    public String content;
    public String skill;
    public boolean idea_visible;
    public String user;
    public String overview;

    public Post(ParseObject parseObject) {
        this.email = parseObject.getString("email");
        this.content = parseObject.getString("content");
        this.skill = parseObject.getString("skill");
        this.user = parseObject.getString("user");
        this.idea_visible = parseObject.getBoolean("idea_visible");
        this.overview = parseObject.getString("overview");
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
