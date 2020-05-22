package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class MarvelThumbnail implements Parcelable {

    @Expose
    private String extension;
    @Expose
    private String path;

    private MarvelThumbnail(Parcel in) {
        extension = in.readString();
        path = in.readString();
    }

    protected static final Creator<MarvelThumbnail> CREATOR = new Creator<MarvelThumbnail>() {
        @Override
        public MarvelThumbnail createFromParcel(Parcel in) {
            return new MarvelThumbnail(in);
        }

        @Override
        public MarvelThumbnail[] newArray(int size) {
            return new MarvelThumbnail[size];
        }
    };

    public MarvelThumbnail(String extension, String path) {
        this.extension = extension;
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(extension);
        dest.writeString(path);
    }
}
