package com.ygor.macedo.dev.android.desafiomarvel.data.service;

import com.ygor.macedo.dev.android.desafiomarvel.data.model.MarvelData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApi {
    @GET("comics?")
    Observable<MarvelData> getMarvelComicsApi(
            @Query("format") String format,
            @Query("formatType") String formatType,
            @Query("noVariants") boolean noVariants,
            @Query("orderBy") String orderBy,
            @Query("limit") String limit,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey);
}