package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class MarvelTextObject implements Parcelable {

    @Expose
    private String language;
    @Expose
    private String text;
    @Expose
    private String type;

    protected MarvelTextObject(Parcel in) {
        language = in.readString();
        text = in.readString();
        type = in.readString();

    }

    public static final Creator<MarvelTextObject> CREATOR = new Creator<MarvelTextObject>() {
        @Override
        public MarvelTextObject createFromParcel(Parcel in) {
            return new MarvelTextObject(in);
        }

        @Override
        public MarvelTextObject[] newArray(int size) {
            return new MarvelTextObject[size];
        }
    };

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        dest.writeString(language);
        dest.writeString(text);
        dest.writeString(type);
    }
}
