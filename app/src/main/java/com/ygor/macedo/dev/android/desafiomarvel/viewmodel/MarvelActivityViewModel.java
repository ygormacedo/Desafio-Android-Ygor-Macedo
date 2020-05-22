package com.ygor.macedo.dev.android.desafiomarvel.viewmodel;

import android.app.Application;

import com.ygor.macedo.dev.android.desafiomarvel.data.model.MarvelRepository;
import com.ygor.macedo.dev.android.desafiomarvel.data.model.MarvelResults;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MarvelActivityViewModel extends AndroidViewModel {

    private MarvelRepository marvelRepository;

    public MarvelActivityViewModel(@NonNull Application application) {
        super(application);
        marvelRepository = new MarvelRepository(application);
    }

    public LiveData<List<MarvelResults>> getMarvelComics() {
        return marvelRepository.getResultLiveData();
    }

    public void clear() {
        marvelRepository.clear();
    }
}
