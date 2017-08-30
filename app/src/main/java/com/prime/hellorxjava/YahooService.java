package com.prime.hellorxjava;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by KKT on 8/23/2017.
 **/

public interface YahooService {

    @GET("yql?format=json")
    Single<YahooStockResults> yqlQuery(
            @Query("q") String query,
            @Query("env") String env
    );
}
