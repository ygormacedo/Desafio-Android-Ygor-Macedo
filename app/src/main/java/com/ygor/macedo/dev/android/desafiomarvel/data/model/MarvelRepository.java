package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.app.Application;

import com.ygor.macedo.dev.android.desafiomarvel.data.service.MarvelRetrofitService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.ygor.macedo.dev.android.desafiomarvel.util.MarvelKeysConstants.PRIVATE_KEY;
import static com.ygor.macedo.dev.android.desafiomarvel.util.MarvelKeysConstants.PUBLIC_KEY;
import static com.ygor.macedo.dev.android.desafiomarvel.util.MarvelMd5HashEncription.md5;

public class MarvelRepository {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<MarvelData>> resultLiveData = new MutableLiveData<>();
    private List<MarvelData> marvelResultsList = new ArrayList<MarvelData>();

    public MarvelRepository(Application application) {
        String ts = Long.toString(System.currentTimeMillis() / 1000);
        String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);

        Observable<MarvelData> dataResponseMarvel = MarvelRetrofitService.getApiService().getMarvelComicsApi("magazine", "comic", true, "focDate", "50", ts, hash, PUBLIC_KEY);

        compositeDisposable.add(dataResponseMarvel.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap((Function<MarvelData, Observable<MarvelResults>>) dataResponse ->
                        Observable.fromArray(dataResponse.getMarvelResults().toArray(new MarvelResults[0]))
                                .subscribe(new boolean[]{marvelResultsList.add(dataResponse)}, new void[]{resultLiveData.postValue(marvelResultsList)})));
    }


    public MutableLiveData<List<MarvelData>> getResultLiveData() {
        return resultLiveData;
    }

    public void clear() {
        compositeDisposable.clear();
    }
}