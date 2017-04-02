package com.example.android.teamformation;

import android.os.Parcel;
import android.os.Parcelable;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

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
    public String id;

    public Post(ParseObject parseObject) {
        this.email = parseObject.getString("email");
        this.content = parseObject.getString("content");
        this.skill = parseObject.getString("skill");
        this.user = parseObject.getString("user");
        this.idea_visible = parseObject.getBoolean("idea_visible");
        this.overview = parseObject.getString("overview");
        this.id = parseObject.getObjectId();
    }

    protected Post(Parcel in) {
        email = in.readString();
        content = in.readString();
        skill = in.readString();
        idea_visible = in.readByte() != 0;
        user = in.readString();
        overview = in.readString();
        id = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(content);
        parcel.writeString(skill);
        parcel.writeByte((byte) (idea_visible ? 1 : 0));
        parcel.writeString(user);
        parcel.writeString(overview);
        parcel.writeString(id);
    }
}
