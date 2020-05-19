package com.ygor.macedo.dev.android.desafiomarvel.util;

import com.ygor.macedo.dev.android.desafiomarvel.data.model.ComicsResponse;

import io.reactivex.Single;

import static com.ygor.macedo.dev.android.desafiomarvel.data.service.RetrofitService.getApiService;
import static com.ygor.macedo.dev.android.desafiomarvel.util.md5.md5;

public class ComicsRepository {

    //Chaves de acesso a Api Developer Marvel
    public static final String PUBLIC_KEY = "e4332566bcaa38e6c29c436f28e0e9c5";
    public static final String PRIVATE_KEY = "b1d3109cbf154fc35fe60b87a7fa698e72a9e553";

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
