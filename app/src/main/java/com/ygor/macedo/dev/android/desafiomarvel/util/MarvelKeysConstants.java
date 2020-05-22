package com.ygor.macedo.dev.android.desafiomarvel.util;

import android.database.Observable;

import com.ygor.macedo.dev.android.desafiomarvel.data.model.MarvelRepository;
import com.ygor.macedo.dev.android.desafiomarvel.data.model.MarvelResults;

import static com.ygor.macedo.dev.android.desafiomarvel.data.service.MarvelRetrofitService.getApiService;
import static com.ygor.macedo.dev.android.desafiomarvel.util.MarvelMd5HashEncription.md5;

public class MarvelKeysConstants {

    //Chaves de acesso a Api Developer Marvel
    public static final String PUBLIC_KEY = "e4332566bcaa38e6c29c436f28e0e9c5";
    public static final String PRIVATE_KEY = "b1d3109cbf154fc35fe60b87a7fa698e72a9e553";

}
