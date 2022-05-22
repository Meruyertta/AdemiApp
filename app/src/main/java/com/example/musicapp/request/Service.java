package com.example.musicapp.request;
import com.example.musicapp.utils.Credentials;
import com.example.musicapp.utils.HmApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static Retrofit.Builder retrofitBuilder=
            new Retrofit.Builder()
                    .baseUrl(Credentials.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit=retrofitBuilder.build();
    private static HmApi hmApi=retrofit.create(HmApi.class);

    public static HmApi getHmApi(){
        return hmApi;
    }
}
