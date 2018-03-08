package com.romansg.curso3semana2;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tiNombreCompleto;
    private DatePicker dpFechaNacimiento;
    private TextInputLayout tiTelefono;
    private TextInputLayout tiEmail;
    private TextInputLayout tiDescripcion;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asociarControles();

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verResumenDatos();
            }
        });
    }

    /**
     * Asocia los controles de la interfaz con los miembros privados
     */
    public void asociarControles() {
        tiNombreCompleto = findViewById(R.id.main_tiNombreCompleto);
        dpFechaNacimiento = findViewById(R.id.main_dpFechaNacimiento);
        tiTelefono = findViewById(R.id.main_tiTelefono);
        tiEmail = findViewById(R.id.main_tiEmail);
        tiDescripcion = findViewById(R.id.main_tiDescripcion);
        btnSiguiente = findViewById(R.id.main_btnSiguiente);
    }

    public void verResumenDatos() {
        Intent intent = new Intent(this, ResumenDatosActivity.class);

        // Extraer datos de los controles
        String nombreCompleto = tiNombreCompleto.getEditText().getText().toString();
        String telefono = tiTelefono.getEditText().getText().toString();
        String email = tiEmail.getEditText().getText().toString();
        String descripcion = tiDescripcion.getEditText().getText().toString();

        int dia = dpFechaNacimiento.getDayOfMonth();
        int mes = dpFechaNacimiento.getMonth();
        int año = dpFechaNacimiento.getYear();

        // Dar formato a la fecha (tomado de https://stackoverflow.com/questions/14851285/how-to-get-datepicker-value-in-date-format)
        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes, dia);
        SimpleDateFormat sdf = new SimpleDateFormat("d 'de' MMMM 'de' yyyy");
        String fechaNacimiento = sdf.format(calendario.getTime());

        // Pasar datos a la siguiente actividad
        intent.putExtra("nombreCompleto", nombreCompleto);
        intent.putExtra("fechaNacimiento", fechaNacimiento);
        intent.putExtra("telefono", telefono);
        intent.putExtra("email", email);
        intent.putExtra("descripcion", descripcion);

        startActivity(intent);
    }
}
