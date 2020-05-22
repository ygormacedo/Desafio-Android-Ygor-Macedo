package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class MarvelImage implements Parcelable {

    @Expose
    private String extension;
    @Expose
    private String path;

    protected MarvelImage(Parcel in) {
        extension = in.readString();
        path = in.readString();
    }

    public static final Creator<MarvelImage> CREATOR = new Creator<MarvelImage>() {
        @Override
        public MarvelImage createFromParcel(Parcel in) {
            return new MarvelImage(in);
        }

        @Override
        public MarvelImage[] newArray(int size) {
            return new MarvelImage[size];
        }
    };

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
