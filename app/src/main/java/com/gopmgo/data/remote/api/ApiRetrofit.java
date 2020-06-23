package com.gopmgo.data.remote.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {

    private static final String BASE_URL = "https://gopmgo.herokuapp.com/api/";
    private static long TIMOEOUT_MAX = 45L;
    private static Retrofit retrofit;


    public static Retrofit getInstance() {
        if (retrofit == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(TIMOEOUT_MAX, TimeUnit.SECONDS)
                    .writeTimeout(TIMOEOUT_MAX, TimeUnit.SECONDS)
                    .readTimeout(TIMOEOUT_MAX, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}