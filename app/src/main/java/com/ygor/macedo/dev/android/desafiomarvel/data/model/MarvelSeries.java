package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class MarvelSeries implements Parcelable {

    @Expose
    private String name;
    @Expose
    private String resourceURI;

    protected MarvelSeries(Parcel in) {
        name = in.readString();
        resourceURI = in.readString();
    }

    private static final Creator<MarvelSeries> CREATOR = new Creator<MarvelSeries>() {
        @Override
        public MarvelSeries createFromParcel(Parcel in) {
            return new MarvelSeries(in);
        }

        @Override
        public MarvelSeries[] newArray(int size) {
            return new MarvelSeries[size];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(resourceURI);
        dest.writeString(name);

    }
}
