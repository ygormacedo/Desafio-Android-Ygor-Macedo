package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class MarvelItem implements Parcelable {

    @Expose
    private String name;
    @Expose
    private String resourceURI;
    @Expose
    private String role;
    @Expose
    private String type;

    protected MarvelItem(Parcel in) {
        name = in.readString();
        resourceURI = in.readString();
        role = in.readString();
        type = in.readString();
    }

    public static final Creator<MarvelItem> CREATOR = new Creator<MarvelItem>() {
        @Override
        public MarvelItem createFromParcel(Parcel in) {
            return new MarvelItem(in);
        }

        @Override
        public MarvelItem[] newArray(int size) {
            return new MarvelItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(resourceURI);
        dest.writeString(role);
        dest.writeString(type);

    }
}
