package com.ygor.macedo.dev.android.desafiomarvel.util;

import com.ygor.macedo.dev.android.desafiomarvel.data.model.ComicsResponse;

import io.reactivex.Single;

import static com.ygor.macedo.dev.android.desafiomarvel.data.service.RetrofitService.getApiService;
import static com.ygor.macedo.dev.android.desafiomarvel.util.md5.md5;

public class ComicsRepository {

    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0";
    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";

    public Single<ComicsResponse> getComics() {
        String ts = Long.toString(System.currentTimeMillis() / 1000);
        String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);
        return getApiService().getComics("magazine", "comic", true, "focDate", "50", ts, hash, PUBLIC_KEY);
    }

    private Single<ComicsResponse> getComics(String magazine, String comic, boolean b,
                                             String focDate, String s, String ts, String hash, String publicKey) {
        return getComics();
    }

}
