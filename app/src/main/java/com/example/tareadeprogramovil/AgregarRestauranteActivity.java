package com.example.tareadeprogramovil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AgregarRestauranteActivity extends AppCompatActivity {

    EditText etNombre, etUbicacion, etCapacidad, etTipoCocina, etCalificacion, etClientesServidos;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_restaurante);

        etNombre = findViewById(R.id.etNombre);
        etUbicacion = findViewById(R.id.etUbicacion);
        etCapacidad = findViewById(R.id.etCapacidad);
        etTipoCocina = findViewById(R.id.etTipoCocina);
        etCalificacion = findViewById(R.id.etCalificacion);
        etClientesServidos = findViewById(R.id.etClientesServidos); // NUEVO
        btnGuardar = findViewById(R.id.btnGuardar);
        Spinner spTipo = findViewById(R.id.spTipoRestaurante);




        btnGuardar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            String ubicacion = etUbicacion.getText().toString();
            int capacidad = Integer.parseInt(etCapacidad.getText().toString());
            String tipoCocina = etTipoCocina.getText().toString();
            double calificacion = Double.parseDouble(etCalificacion.getText().toString());
            int clientesServidos = Integer.parseInt(etClientesServidos.getText().toString());

            // Ya no se crea el objeto, solo se pasa como string separado por ;
            Intent resultado = new Intent();
            resultado.putExtra("nuevoRestaurante", nombre + ";" + ubicacion + ";" + capacidad + ";" + tipoCocina + ";" + calificacion + ";" + clientesServidos);
            setResult(RESULT_OK, resultado);
            finish();

            Toast.makeText(this, "Restaurante agregado!", Toast.LENGTH_SHORT).show();
        });
    }
}
