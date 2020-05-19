package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Creators implements Parcelable {

    @Expose
    private String collectionURI;
    @Expose
    private Long available;
    @Expose
    private Long returned;
    @Expose
    private List<Item> items;

    protected Creators(Parcel in) {
        collectionURI = in.readString();
        items = in.createTypedArrayList(Item.CREATOR);
        if (in.readByte() == 0) {
            available = null;
        } else {
            available = in.readLong();
        }
        if (in.readByte() == 0) {
            returned = null;
        } else {
            returned = in.readLong();
        }
    }

    private static final Creator<Creators> CREATOR = new Creator<Creators>() {
        @Override
        public Creators createFromParcel(Parcel in) {
            return new Creators(in);
        }

        @Override
        public Creators[] newArray(int size) {
            return new Creators[size];
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

    public Long getReturned() {
        return returned;
    }

    public void setReturned(Long returned) {
        this.returned = returned;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(collectionURI);
        dest.writeTypedList(items);
        if (returned == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(returned);
        }
        if (available == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(available);
        }

    }
}
