package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Stories implements Parcelable {

    @Expose
    private String collectionURI;
    @Expose
    private List<Item> items;
    @Expose
    private Long available;
    @Expose
    private Long returned;

    protected Stories(Parcel in){
        collectionURI = in.readString();
        items = in.createTypedArrayList(Item.CREATOR);
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

    private static final Creator<Stories> CREATOR = new Creator<Stories>() {
        @Override
        public Stories createFromParcel(Parcel in) {
            return new Stories(in);
        }

        @Override
        public Stories[] newArray(int size) {
            return new Stories[size];
        }
    };

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
        dest.writeTypedList(items);
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
