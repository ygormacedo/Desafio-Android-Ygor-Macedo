package com.ygor.macedo.dev.android.desafiomarvel.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.ygor.macedo.dev.android.desafiomarvel.R;

import androidx.appcompat.app.AppCompatActivity;


@SuppressLint("Registered")
public class ImagePopupActivity extends AppCompatActivity {

    private ImageView imageComic;
    private ImageView imageClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_image_popup);

        // Inicializa as views que serão utilizadas na activity
        imageComic = findViewById(R.id.imageComic);
        imageClose = findViewById(R.id.imageViewClose);

        // Pegamos o quadrinho que que foi clicado na imagem anterior
        String image = getIntent().getStringExtra("image");

        // Carregamos a imagem
        Picasso.get().load(image)
                .placeholder(R.drawable.logo_marvel)
                .error(R.drawable.logo_marvel)
                .into(imageComic);

        // Adidionamos o evento de click para fechar-mos a tela
        imageClose.setOnClickListener(v -> finish());
    }
}
