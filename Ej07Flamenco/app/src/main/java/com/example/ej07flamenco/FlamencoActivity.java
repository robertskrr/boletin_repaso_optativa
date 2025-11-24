package com.example.ej07flamenco;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FlamencoActivity extends AppCompatActivity {

    private ImageView imagen;
    private TextView descripcion;
    private String palo;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flamenco);
        asignarComponentes();
        mostrarInfoPalo();
    }

    private void asignarComponentes() {
        imagen = findViewById(R.id.imageViewPalo);
        descripcion = findViewById(R.id.textViewDescripcion);
    }

    private void mostrarInfoPalo() {
        Intent intent = getIntent();

        palo = intent.getStringExtra("palo");

        switch (palo) {
            case "sevillanas":
                mp = MediaPlayer.create(this, R.raw.sevillanas);
                imagen.setImageResource(R.drawable.sevillanas);
                descripcion.setText(R.string.descr_sevillanas);
                break;
            case "bulerias":
                mp = MediaPlayer.create(this, R.raw.bulerias);
                imagen.setImageResource(R.drawable.bulerias);
                descripcion.setText(R.string.descr_bulerias);
                break;
            case "fandangos":
                mp = MediaPlayer.create(this, R.raw.fandangos);
                imagen.setImageResource(R.drawable.fandangos);
                descripcion.setText(R.string.descr_fandangos);
                break;
        }
    }

    public void reproducir(View view) {
        mp.start();
    }

    public void volver(View view) {
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}