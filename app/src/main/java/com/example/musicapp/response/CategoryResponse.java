package com.example.musicapp.response;

import com.example.musicapp.models.CategoryModel;
import com.google.gson.annotations.SerializedName;

//this class if for single category request
public class CategoryResponse {

    // 1 - Finding the category object
    // @SerializedName()


    private CategoryModel categoryModel;
    public CategoryModel getCategoryModel(){
        return categoryModel;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "categoryModel=" + categoryModel +
                '}';
    }


}
