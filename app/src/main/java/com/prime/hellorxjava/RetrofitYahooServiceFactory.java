package com.prime.hellorxjava;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KKT on 8/23/2017.
 **/

public class RetrofitYahooServiceFactory {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Retrofit retrofit = new Retrofit.Builder()
            .client(client)                                                 // set actual HTTP client that we'll be using
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())      // integrate RxJava compatibility into Retrofit Library
            .addConverterFactory(GsonConverterFactory.create())             // for JSON parsing into JAVA object
            .baseUrl("https://query.yahooapis.com/v1/public/")
            .build();

    public YahooService create(){
        return retrofit.create(YahooService.class);
    }
}
