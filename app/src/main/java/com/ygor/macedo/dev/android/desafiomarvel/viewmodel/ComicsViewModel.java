package com.ygor.macedo.dev.android.desafiomarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import com.ygor.macedo.dev.android.desafiomarvel.data.model.Result;
import com.ygor.macedo.dev.android.desafiomarvel.util.ComicsRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.ygor.macedo.dev.android.desafiomarvel.util.ComicsRepository.PUBLIC_KEY;

public class ComicsViewModel extends AndroidViewModel {

    // Variáveis que serão usadas para buscar os quadrinhos na API
    private MutableLiveData<List<Result>> resultLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private ComicsRepository repository = new ComicsRepository();

    public ComicsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getResults() {
        return resultLiveData;
    }

    public void getComics() {
        // Adicionamos a chamada a um disposible para podermos eliminar o disposable da destruição do viewmodel
        disposable.add(repository.getComics()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(subscription -> {})
                .doAfterTerminate(() -> {})
                .subscribe(response -> {
                    // Chegou aqui então alteramos o live data, assim a View que está observando ele pode atualizar a tela
                    resultLiveData.setValue(response.getData().getResults());
                }, throwable -> {
                    Log.i("LOG", "Error: " + throwable.getMessage());
                }));
    }
}
