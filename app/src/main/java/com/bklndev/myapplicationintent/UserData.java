package com.bklndev.myapplicationintent;

import android.os.Parcel;
import android.os.Parcelable;

public class UserData implements Parcelable {
    private final String exname;
    private final String email;
    private final String status;

    public String getExname() {
        return exname;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public UserData(String exname, String email, String status) {
        this.exname = exname;
        this.email = email;
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.exname);
        dest.writeString(this.email);
        dest.writeString(this.status);
    }

    protected UserData(Parcel in) {
        this.exname = in.readString();
        this.email = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<UserData> CREATOR = new Parcelable.Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel source) {
            return new UserData(source);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };
}
