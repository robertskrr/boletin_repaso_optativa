package com.example.ej04traductorexpres;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class ActivityTraduccion extends AppCompatActivity {

    private TextView textoTraducido;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traduccion);

        asignarComponentes();
        mostrarTraduccion();
    }

    private void asignarComponentes() {
        textoTraducido = findViewById(R.id.textViewTraduccion);
        prefs = getSharedPreferences("MisPrefs", MODE_PRIVATE);
    }

    private void mostrarTraduccion() {
        Map<String, String> traducciones = Traducciones.getTraducciones();

        String traducir = prefs.getString("Palabra", null);
        String palabraTraducida = traducciones.get(traducir);

        textoTraducido.setText(palabraTraducida);
    }


}