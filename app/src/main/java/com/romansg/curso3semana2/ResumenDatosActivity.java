package com.romansg.curso3semana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResumenDatosActivity extends AppCompatActivity {
    private TextView tvNombreCompleto;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_datos);

        asociarControles();

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Obtener datos pasados
        Bundle extras = getIntent().getExtras();

        String nombreCompleto = extras.getString("nombreCompleto");
        String fechaNacimiento = extras.getString("fechaNacimiento");
        String telefono = extras.getString("telefono");
        String email = extras.getString("email");
        String descripcion = extras.getString("descripcion");

        // Llenar controles
        tvNombreCompleto.setText(nombreCompleto);
        tvFechaNacimiento.setText(fechaNacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
    }

    public void asociarControles() {
        tvNombreCompleto = findViewById(R.id.resumen_datos_tvNombreCompleto);
        tvFechaNacimiento = findViewById(R.id.resumen_datos_tvFechaNacimiento);
        tvTelefono = findViewById(R.id.resumen_datos_tvTelefono);
        tvEmail = findViewById(R.id.resumen_datos_tvEmail);
        tvDescripcion = findViewById(R.id.resumen_datos_tvDescripcion);
        btnEditar = findViewById(R.id.main_btnEditar);
    }
}
