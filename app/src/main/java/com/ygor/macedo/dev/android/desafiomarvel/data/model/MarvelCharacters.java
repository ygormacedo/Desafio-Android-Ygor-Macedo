package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MarvelCharacters implements Parcelable {

    @Expose
    private Long available;
    @Expose
    private String colletionURI;
    @Expose
    private List<MarvelItem> marvelItems;
    @Expose
    private Long returned;

    protected MarvelCharacters(Parcel in) {
        if (in.readByte() == 0) {
            available = null;
        } else {
            available = in.readLong();
        }
        colletionURI = in.readString();
        marvelItems = in.createTypedArrayList(MarvelItem.CREATOR);
        if (in.readByte() == 0) {
            returned = null;
        } else {
            returned = in.readLong();
        }
    }

    public static final Creator<MarvelCharacters> CREATOR = new Creator<MarvelCharacters>() {
        @Override
        public MarvelCharacters createFromParcel(Parcel in) {
            return new MarvelCharacters(in);
        }

        @Override
        public MarvelCharacters[] newArray(int size) {
            return new MarvelCharacters[size];
        }
    };

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public String getColletionURI() {
        return colletionURI;
    }

    public void setColletionURI(String colletionURI) {
        this.colletionURI = colletionURI;
    }

    public List<MarvelItem> getMarvelItems() {
        return marvelItems;
    }

    public void setMarvelItems(List<MarvelItem> marvelItems) {
        this.marvelItems = marvelItems;
    }

    public Long getReturned() {
        return returned;
    }

    public void setReturned(Long returned) {
        this.returned = returned;
    }

    @Override

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
