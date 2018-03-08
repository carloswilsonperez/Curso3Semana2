package com.romansg.curso3semana2;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tiNombreCompleto;
    private TextInputLayout tiTelefono;
    private TextInputLayout tiEmail;
    private TextInputLayout tiDescripcion;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiNombreCompleto = findViewById(R.id.main_tiNombreCompleto);
        tiTelefono = findViewById(R.id.main_tiTelefono);
        tiEmail = findViewById(R.id.main_tiEmail);
        tiDescripcion = findViewById(R.id.main_tiDescripcion);
        btnSiguiente = findViewById(R.id.main_btnSiguiente);

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
        String telefono = tiTelefono.getEditText().getText().toString();
        String email = tiEmail.getEditText().getText().toString();
        String descripcion = tiDescripcion.getEditText().getText().toString();

        intent.putExtra("nombreCompleto", nombreCompleto);
        intent.putExtra("telefono", telefono);
        intent.putExtra("email", email);
        intent.putExtra("descripcion", descripcion);

        startActivity(intent);
    }
}
