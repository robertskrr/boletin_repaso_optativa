package com.example.ej10quizinteractivo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Pregunta1Activity extends AppCompatActivity {
    private int puntuacion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);
    }

    private void pregunta2(Intent intent) {
        startActivity(intent);
    }

    public void incorrecta(View view) {
        Intent intent = new Intent(this, Pregunta2Activity.class);
        intent.putExtra("puntuacion", puntuacion);
        pregunta2(intent);
    }

    public void correcta(View view) {
        Intent intent = new Intent(this, Pregunta2Activity.class);
        puntuacion++;
        intent.putExtra("puntuacion", puntuacion);
        pregunta2(intent);
    }
}