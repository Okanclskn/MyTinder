package com.okan.mytinder.api;

import android.app.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Service service;

    public static Service getClient() {
        if (service == null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://boombox.ng")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            service = retrofit.create(Service.class);
        }
        return service;
    }

}
