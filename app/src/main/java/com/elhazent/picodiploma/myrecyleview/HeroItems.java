package com.elhazent.picodiploma.myrecyleview;

import android.os.Parcel;
import android.os.Parcelable;

public class HeroItems implements Parcelable {
    private String name, from, photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.from);
        dest.writeString(this.photo);
    }
    HeroItems(){
    }

    private HeroItems(Parcel in){
        this.name = in.readString();
        this.from = in.readString();
        this.photo = in.readString();
    }
    public static final Parcelable.Creator<HeroItems> CREATOR = new Creator<HeroItems>() {
        @Override
        public HeroItems createFromParcel(Parcel source) {
            return new HeroItems(source);
        }

        @Override
        public HeroItems[] newArray(int size) {
            return new HeroItems[size];
        }
    };
}
