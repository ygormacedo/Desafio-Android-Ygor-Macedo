package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Events implements Parcelable {

    @Expose
    private String collectionURI;
    @Expose
    private Long available;
    @Expose
    private List<Item> items;
    @Expose
    private Long returned;

    protected Events(Parcel in) {
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
        items = in.createTypedArrayList(Item.CREATOR);
    }

    private static final Creator<Events> CREATOR = new Creator<Events>() {
        @Override
        public Events createFromParcel(Parcel in) {
            return new Events(in);
        }

        @Override
        public Events[] newArray(int size) {
            return new Events[size];
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
        dest.writeTypedList(items);
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
