package com.telephone.app;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shuhj on 2016/12/23.
 */

public class PhoneBook implements Parcelable {

    private int id;
    private String name;
    private String phone;
    private int dialCount;

    public PhoneBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDialCount() {
        return dialCount;
    }

    public void setDialCount(int dialCount) {
        this.dialCount = dialCount;
    }


    protected PhoneBook(Parcel in) {
        id = in.readInt();
        name = in.readString();
        phone = in.readString();
        dialCount = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeInt(dialCount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhoneBook> CREATOR = new Creator<PhoneBook>() {
        @Override
        public PhoneBook createFromParcel(Parcel in) {
            return new PhoneBook(in);
        }

        @Override
        public PhoneBook[] newArray(int size) {
            return new PhoneBook[size];
        }
    };
}
