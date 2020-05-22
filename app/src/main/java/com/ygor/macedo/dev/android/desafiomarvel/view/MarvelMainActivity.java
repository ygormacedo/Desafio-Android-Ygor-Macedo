package com.ygor.macedo.dev.android.desafiomarvel.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.ygor.macedo.dev.android.desafiomarvel.R;
import com.ygor.macedo.dev.android.desafiomarvel.adapter.MarvelRecyclerViewAdapter;
import com.ygor.macedo.dev.android.desafiomarvel.data.model.MarvelResults;
import com.ygor.macedo.dev.android.desafiomarvel.util.RecyclerItemClickListener;
import com.ygor.macedo.dev.android.desafiomarvel.viewmodel.MarvelActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MarvelMainActivity extends AppCompatActivity {

    private List<MarvelResults> marvelList = new ArrayList<>();
    private RecyclerView marvelRecyclerView;
    private MarvelRecyclerViewAdapter marvelAdapter;
    private MarvelActivityViewModel marvelActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_main);

        marvelActivityViewModel = ViewModelProviders.of(this).get(MarvelActivityViewModel.class);

        getMarvelHq();

    }

    private void getMarvelHq() {
        marvelActivityViewModel.getMarvelComics().observe(this, marvel -> {
            marvelList = marvel;
            setMarvelRecyclerView();
            touchRecyclear();

        });
    }

    private void setMarvelRecyclerView() {
        marvelRecyclerView = findViewById(R.id.hqRecyclerView);
        marvelAdapter = new MarvelRecyclerViewAdapter(marvelList);
        marvelRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        marvelRecyclerView.setAdapter(marvelAdapter);
    }

    private void touchRecyclear() {
        marvelRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                this, marvelRecyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        MarvelResults results = marvelList.get(position);
                        Intent intent = new Intent(view.getContext(), MarvelDetailActivity.class);
                        intent.putExtra("movie", results);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        marvelActivityViewModel.clear();
    }
}
