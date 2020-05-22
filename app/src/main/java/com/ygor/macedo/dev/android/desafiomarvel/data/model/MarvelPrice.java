package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class MarvelPrice implements Parcelable {

    @Expose
    private Double price;
    @Expose
    private String type;

    private MarvelPrice(Parcel in) {
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
        type = in.readString();
    }

    protected final static Creator<MarvelPrice> CREATOR = new Creator<MarvelPrice>() {
        @Override
        public MarvelPrice createFromParcel(Parcel in) {
            return new MarvelPrice(in);
        }

        @Override
        public MarvelPrice[] newArray(int size) {
            return new MarvelPrice[size];
        }
    };

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (price == null) {
            dest.writeDouble((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(price);
        }
        dest.writeString(type);
    }
}
