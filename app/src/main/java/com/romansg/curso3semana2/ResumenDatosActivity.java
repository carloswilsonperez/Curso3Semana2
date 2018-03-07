package com.romansg.curso3semana2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResumenDatosActivity extends AppCompatActivity {
    private TextView tvNombreCompleto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_datos);

        tvNombreCompleto = findViewById(R.id.tvNombreCompleto);

        Bundle extras = getIntent().getExtras();

        String nombreCompleto = extras.getString("nombreCompleto");

        tvNombreCompleto.setText(nombreCompleto);
    }
}
