package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MarvelStories implements Parcelable {

    @Expose
    private String collectionURI;
    @Expose
    private List<MarvelItem> marvelItems;
    @Expose
    private Long available;
    @Expose
    private Long returned;

    protected MarvelStories(Parcel in){
        collectionURI = in.readString();
        marvelItems = in.createTypedArrayList(MarvelItem.CREATOR);
        if (in.readByte() == 0) {
            available = null;
        }else {
            available = in.readLong();
        }
        if (in.readByte() == 0) {
            returned = null;
        }else {
            returned = in.readLong();
        }
    }

    private static final Creator<MarvelStories> CREATOR = new Creator<MarvelStories>() {
        @Override
        public MarvelStories createFromParcel(Parcel in) {
            return new MarvelStories(in);
        }

        @Override
        public MarvelStories[] newArray(int size) {
            return new MarvelStories[size];
        }
    };

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<MarvelItem> getMarvelItems() {
        return marvelItems;
    }

    public void setMarvelItems(List<MarvelItem> marvelItems) {
        this.marvelItems = marvelItems;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(collectionURI);
        dest.writeTypedList(marvelItems);
        if (available == null){
            dest.writeByte((byte)0);
        }else {
            dest.writeByte((byte)1);
            dest.writeLong(available);
        }
        if (returned == null){
            dest.writeLong((byte)1);
            dest.writeLong(returned);
        }
    }
}
