package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MarvelEvents implements Parcelable {

    @Expose
    private String collectionURI;
    @Expose
    private Long available;
    @Expose
    private List<MarvelItem> marvelItems;
    @Expose
    private Long returned;

    protected MarvelEvents(Parcel in) {
        if (in.readByte() == 0) {
            available = null;
        } else {
            available = in.readLong();
        }
        collectionURI = in.readString();
        if (in.readByte() == 0) {
            returned = null;
        } else {
            returned = in.readLong();
        }
        marvelItems = in.createTypedArrayList(MarvelItem.CREATOR);
    }

    private static final Creator<MarvelEvents> CREATOR = new Creator<MarvelEvents>() {
        @Override
        public MarvelEvents createFromParcel(Parcel in) {
            return new MarvelEvents(in);
        }

        @Override
        public MarvelEvents[] newArray(int size) {
            return new MarvelEvents[size];
        }
    };

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(collectionURI);
        dest.writeTypedList(marvelItems);
        if (returned == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(returned);
        }
        if (available == null) {
            dest.writeLong((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(available);
        }

    }
}
