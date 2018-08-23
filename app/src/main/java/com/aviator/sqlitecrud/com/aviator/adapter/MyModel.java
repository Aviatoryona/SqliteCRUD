package com.aviator.sqlitecrud.com.aviator.adapter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aviator on 11/19/2017.
 */

public class MyModel implements Parcelable {
    String id,name,eng,math,kis;

    protected MyModel(Parcel in) {
        id = in.readString();
        name = in.readString();
        eng = in.readString();
        math = in.readString();
        kis = in.readString();
    }

    public MyModel() {
    }

    public static final Creator<MyModel> CREATOR = new Creator<MyModel>() {
        @Override
        public MyModel createFromParcel(Parcel in) {
            return new MyModel(in);
        }

        @Override
        public MyModel[] newArray(int size) {
            return new MyModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getKis() {
        return kis;
    }

    public void setKis(String kis) {
        this.kis = kis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(eng);
        dest.writeString(math);
        dest.writeString(kis);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ((MyModel)obj).getId().equals(id);
    }
}
