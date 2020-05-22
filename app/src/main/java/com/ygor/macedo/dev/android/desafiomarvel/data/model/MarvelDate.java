package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class MarvelDate implements Parcelable {

    @Expose
    private String date;
    @Expose
    private String type;

    private MarvelDate(Parcel in) {
        date = in.readString();
        type = in.readString();
    }

    public static final Creator<MarvelDate> CREATOR = new Creator<MarvelDate>() {
        @Override
        public MarvelDate createFromParcel(Parcel in) {
            return new MarvelDate(in);
        }

        @Override
        public MarvelDate[] newArray(int size) {
            return new MarvelDate[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        dest.writeString(date);
        dest.writeString(type);
    }
}
