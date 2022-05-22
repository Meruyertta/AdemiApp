package com.example.musicapp.utils;

import com.example.musicapp.models.CategoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface HmApi {
    @GET
    Call<List<CategoryModel>> getCategories(
//      @Query("key") String key
            @Url() String url,
            @Header("X-RapidAPI-Host") String header1,
            @Header("X-RapidAPI-Key") String header2
    );
}
