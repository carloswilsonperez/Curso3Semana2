package com.romansg.curso3semana2;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tiNombreCompleto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiNombreCompleto = findViewById(R.id.tiNombreCompleto);

        Button btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verResumenDatos();
            }
        });
    }

    public void verResumenDatos() {
        Intent intent = new Intent(this, ResumenDatosActivity.class);

        String nombreCompleto = tiNombreCompleto.getEditText().getText().toString();
        intent.putExtra("nombreCompleto", nombreCompleto);
        startActivity(intent);
    }
}
