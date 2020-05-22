package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class MarvelUrl implements Parcelable {

    @Expose
    private String type;
    @Expose
    private String url;

    private MarvelUrl(Parcel in) {
        type = in.readString();
        url = in.readString();
    }

    protected static final Creator<MarvelUrl> CREATOR = new Creator<MarvelUrl>() {
        @Override
        public MarvelUrl createFromParcel(Parcel in) {
            return new MarvelUrl(in);
        }

        @Override
        public MarvelUrl[] newArray(int size) {
            return new MarvelUrl[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(url);
    }
}
