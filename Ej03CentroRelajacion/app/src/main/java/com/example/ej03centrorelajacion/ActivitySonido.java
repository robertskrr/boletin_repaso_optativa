package com.example.ej03centrorelajacion;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySonido extends AppCompatActivity {
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido);
        mp = MediaPlayer.create(this, R.raw.sonido);
    }

    public void reproducir(View view) {
        mp.start();
    }

    public void pausar(View view) {
        mp.pause();
    }

    public void detener(View view) {
        mp.stop();
        mp.release();
        mp = MediaPlayer.create(this, R.raw.sonido);
    }
}