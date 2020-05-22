package com.ygor.macedo.dev.android.desafiomarvel.data.service;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.ygor.macedo.dev.android.desafiomarvel.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelRetrofitService {

        // Url da api
        private static final String BASE_URL = "https://gateway.marvel.com/v1/public/";

        // Instancia que criaremos do retrofit
        private static retrofit2.Retrofit retrofit;

        private static retrofit2.Retrofit getRetrofit(){

            if (retrofit == null) {

                //configurações da conexão
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.readTimeout(30, TimeUnit.SECONDS);
                httpClient.connectTimeout(30, TimeUnit.SECONDS);
                httpClient.writeTimeout(30, TimeUnit.SECONDS);

                // Se for Debug habilitamos os logs
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    httpClient.addInterceptor(httpLoggingInterceptor);
                    httpClient.addNetworkInterceptor(new StethoInterceptor());
                }

                // Inicializamos o retrofit
                retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
            }
            return retrofit;
        }

        // Retornamos a instancia da API criada com o retrofit
        public static MarvelApi getApiService() {
            return getRetrofit().create(MarvelApi.class);
        }

    }

