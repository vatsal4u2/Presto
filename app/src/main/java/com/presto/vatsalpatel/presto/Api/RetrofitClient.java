package com.presto.vatsalpatel.presto.Api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://api.flickr.com/services/";
    private static Retrofit mRetrofit;

    public static Retrofit getRetrofitInstance() {
        if (mRetrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            mRetrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return mRetrofit;
    }


}
