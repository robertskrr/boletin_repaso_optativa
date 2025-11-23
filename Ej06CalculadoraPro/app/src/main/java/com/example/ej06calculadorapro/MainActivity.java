package com.example.ej06calculadorapro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNum1;
    private EditText editTextNum2;
    private String tipoOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asignarComponentes();
    }

    private void asignarComponentes() {
        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
    }

    /**
     * Método auxiliar para enviar y validar los numeros y la operacion correspondiente
     *
     * @param operacion
     */
    private void iniciarOperacion(String operacion) {
        if (editTextNum1.getText().toString().trim().isEmpty() || editTextNum2.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(), R.string.noNumeros, Toast.LENGTH_SHORT).show();
            return;
        }

        int num1, num2;

        // Convertimos a int los editText
        try {
            num1 = Integer.parseInt(editTextNum1.getText().toString());
            num2 = Integer.parseInt(editTextNum2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), R.string.numNoValido, Toast.LENGTH_SHORT).show();
            return;
        }
        // Valida que no divida entre 0
        if (operacion.equals("DIVISION")) {
            if (num2 == 0) {
                Toast.makeText(getApplicationContext(), R.string.noDividirEntre0, Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Creamos y configuramos el intent
        Intent intent = new Intent(this, ResultadoActivity.class);

        // Adjuntamos los datos
        intent.putExtra("NUM1", num1);
        intent.putExtra("NUM2", num2);
        intent.putExtra("OPERACION", operacion); // Enviamos el String de la operación

        // Iniciamos la Activity
        startActivity(intent);
    }

    public void sumar(View view) {
        iniciarOperacion("SUMA");
    }

    public void restar(View view) {
        iniciarOperacion("RESTA");
    }

    public void multiplicar(View view) {
        iniciarOperacion("MULTIPLICACION");
    }

    public void dividir(View view) {
        iniciarOperacion("DIVISION");
    }
}