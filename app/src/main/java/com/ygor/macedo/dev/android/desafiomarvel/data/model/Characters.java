package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Characters implements Parcelable {

    @Expose
    private Long available;
    @Expose
    private String colletionURI;
    @Expose
    private List<Item> items;
    @Expose
    private Long returned;

    protected Characters(Parcel in) {
        if (in.readByte() == 0) {
            available = null;
        } else {
            available = in.readLong();
        }
        colletionURI = in.readString();
        items = in.createTypedArrayList(Item.CREATOR);
        if (in.readByte() == 0) {
            returned = null;
        } else {
            returned = in.readLong();
        }
    }

    public static final Creator<Characters> CREATOR = new Creator<Characters>() {
        @Override
        public Characters createFromParcel(Parcel in) {
            return new Characters(in);
        }

        @Override
        public Characters[] newArray(int size) {
            return new Characters[size];
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
    public void writeToParcel(Parcel parcel, int i) {

    }
}
