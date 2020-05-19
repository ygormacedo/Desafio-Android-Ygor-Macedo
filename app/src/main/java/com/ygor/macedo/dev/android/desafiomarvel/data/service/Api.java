package com.ygor.macedo.dev.android.desafiomarvel.data.service;

import com.ygor.macedo.dev.android.desafiomarvel.data.model.ComicsResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("comics?")
    Single<ComicsResponse> getComics(
            @Query("format") String format,
            @Query("formatType") String formatType,
            @Query("noVariants") boolean noVariants,
            @Query("orderBy") String orderBy,
            @Query("limit") String limit,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey);
}