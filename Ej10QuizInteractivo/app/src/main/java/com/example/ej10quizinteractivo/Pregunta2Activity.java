package com.example.ej10quizinteractivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pregunta2Activity extends AppCompatActivity {
    private int puntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2);

        Intent intent = getIntent();
        puntuacion = intent.getIntExtra("puntuacion", 0);
    }

    private void pregunta3(Intent intent) {
        startActivity(intent);
    }

    public void incorrecta(View view) {
        Intent intent = new Intent(this, Pregunta3Activity.class);
        intent.putExtra("puntuacion", puntuacion);
        pregunta3(intent);
    }

    public void correcta(View view) {
        Intent intent = new Intent(this, Pregunta3Activity.class);
        puntuacion++;
        intent.putExtra("puntuacion", puntuacion);
        pregunta3(intent);
    }


}