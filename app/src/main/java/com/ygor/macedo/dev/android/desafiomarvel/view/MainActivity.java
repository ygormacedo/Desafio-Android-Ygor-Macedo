package com.ygor.macedo.dev.android.desafiomarvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ygor.macedo.dev.android.desafiomarvel.R;
import com.ygor.macedo.dev.android.desafiomarvel.adapter.RecyclerViewComicsAdapter;
import com.ygor.macedo.dev.android.desafiomarvel.viewmodel.ComicsViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView hqRecyclerView;
    private ComicsViewModel viewModel;
    private RecyclerViewComicsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        viewModel.getComics();
        // Atualiza a lista com os quadriho buscados na API
        viewModel.getResults().observe(this, results -> adapter.update(results));
    }

    private void initViews() {
        viewModel = ViewModelProviders.of(this).get(ComicsViewModel.class);
        hqRecyclerView = findViewById(R.id.hqRecyclerView);
        adapter = new RecyclerViewComicsAdapter(new ArrayList<>());
        hqRecyclerView.setAdapter(adapter);
        hqRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }
}
