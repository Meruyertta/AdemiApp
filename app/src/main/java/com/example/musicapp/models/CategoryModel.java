package com.example.musicapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryModel implements Parcelable {

    @SerializedName("CatName")
    @Expose()
    private String catName;

    //constructor


    public CategoryModel(String catName) {
        this.catName = catName;
    }

    //getter


    protected CategoryModel(Parcel in) {
        catName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(catName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CategoryModel> CREATOR = new Creator<CategoryModel>() {
        @Override
        public CategoryModel createFromParcel(Parcel in) {
            return new CategoryModel(in);
        }

        @Override
        public CategoryModel[] newArray(int size) {
            return new CategoryModel[size];
        }
    };

    public String getCatName() {
        return catName;
    }


}
