package com.ygor.macedo.dev.android.desafiomarvel.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.squareup.picasso.Picasso;
import com.ygor.macedo.dev.android.desafiomarvel.R;
import com.ygor.macedo.dev.android.desafiomarvel.data.model.MarvelResults;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MarvelDetailActivity extends AppCompatActivity {

    private ImageView imageHero;
    private ImageView imageBackground;
    private ImageView imageBack;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private MarvelResults marvelResults;
    private TextView textTitle;
    private TextView textViewDescription;
    private TextView textViewPublished;
    private TextView textViewPrice;
    private TextView textViewPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hq_detail);

        // Inicializa as views que serão utilizadas na activity
        initViews();

        // Adicionamos a status bar
        setSupportActionBar(toolbar);

        // Pegamos o quadrinho que que foi clicado na lista anterior
        marvelResults = getIntent().getParcelableExtra("comic");

        // Pegamos o nome da transição para fazer a animação
        String transitionName = getIntent().getStringExtra("transitionName");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageHero.setTransitionName(transitionName);
        }


        // Configuramos nas view os valores do quadrinho que pegamos
        textTitle.setText(marvelResults.getTitle());
        textViewDescription.setText(Html.fromHtml(marvelResults.getDescription()));
        textViewPrice.setText("$" + marvelResults.getMarvelPrices().get(0).getPrice());
        textViewPages.setText(marvelResults.getPageCount().toString());

        Picasso.get().load(marvelResults.getMarvelThumbnail().getPath() + "/portrait_incredible." + marvelResults.getMarvelThumbnail().getExtension())
                .placeholder(R.drawable.marvel_logo)
                .error(R.drawable.marvel_logo)
                .into(imageHero);

        if (!marvelResults.getMarvelImages().isEmpty()) {
            Picasso.get().load(marvelResults.getMarvelImages().get(0).getPath() + "/landscape_incredible." + marvelResults.getMarvelImages().get(0).getExtension())
                    .placeholder(R.drawable.marvel_logo)
                    .error(R.drawable.marvel_logo)
                    .into(imageBackground);
        }

        // Mudadamos a forma de mostrar a data DE '2007-10-31 00:00:00' para 'qua, 31 out 2007'
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
            Date date = formatDate.parse(marvelResults.getMarvelDates().get(0).getDate());
            String dateString = format.format(date);
            textViewPublished.setText(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Adicionamos o evendo se click na imagem para irmos para tela
        // que mostra a imagem inteira
        imageHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MarvelDetailActivity.this, MarvelImagePopupActivity.class);
                intent.putExtra("image", marvelResults.getMarvelThumbnail().getPath() + "/detail." + marvelResults.getMarvelThumbnail().getExtension());
                startActivity(intent);
            }
        });

        // Adicionamos o evento de click para finalizarmos a activity
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supportFinishAfterTransition();
            }
        });


        // Adicionamos o evento de scroll, para mostrar ou não a imagem pequena do quadrinho
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    imageHero.setVisibility(View.VISIBLE);
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    imageHero.setVisibility(View.GONE);
                    toolbar.setTitle(marvelResults.getTitle());
                } else {
                    imageHero.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        imageBack = findViewById(R.id.imageBack);
        imageHero = findViewById(R.id.imageComic);
        appBarLayout = findViewById(R.id.app_bar);
        textTitle = findViewById(R.id.textTitle);
        textViewDescription = findViewById(R.id.textViewDesciption);
        textViewPublished = findViewById(R.id.textViewPublished);
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewPages = findViewById(R.id.textViewPages);
        imageBackground = findViewById(R.id.imageBackground);
    }

}
