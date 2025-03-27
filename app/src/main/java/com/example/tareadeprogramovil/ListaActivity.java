package com.example.tareadeprogramovil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_NUEVO = 100;

    private List<Restaurante> listaOriginal;
    private RestauranteAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        RecyclerView rv = findViewById(R.id.rvRestaurantes);
        EditText etBuscar = findViewById(R.id.etBuscar);
        Button btnAgregar = findViewById(R.id.btnAgregarRestaurante);

        // Crear restaurantes de ejemplo
        listaOriginal = new ArrayList<>();
        listaOriginal.add(new RestauranteCasual("Casualito", "Centro", 40, "Mexicana", 4.2, true, 10));
        listaOriginal.add(new RestauranteGourmet("GourmetChef", "Zona Alta", 20, "Francesa", 4.8, 5, 60));
        listaOriginal.add(new FoodTruck("Rápido y Sabroso", "Calles", 30, "Tacos", 4.1, "Centro", "Carnitas", 8));

        adaptador = new RestauranteAdapter(listaOriginal);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adaptador);

        btnAgregar.setOnClickListener(v -> {
            Intent i = new Intent(ListaActivity.this, AgregarRestauranteActivity.class);
            startActivityForResult(i, REQUEST_CODE_NUEVO);
        });

        etBuscar.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtrar(s.toString());
            }
        });
    }

    private void filtrar(String texto) {
        List<Restaurante> filtrados = new ArrayList<>();
        for (Restaurante r : listaOriginal) {
            if (r.getUbicacion().toLowerCase().contains(texto.toLowerCase()) ||
                    r.getTipoCocina().toLowerCase().contains(texto.toLowerCase())) {
                filtrados.add(r);
            }
        }
        adaptador.actualizarLista(filtrados);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_NUEVO && resultCode == RESULT_OK && data != null) {
            String datos = data.getStringExtra("nuevoRestaurante");
            String[] partes = datos.split(";");

            Restaurante nuevo = new Restaurante(
                    partes[0],
                    partes[1],
                    Integer.parseInt(partes[2]),
                    partes[3],
                    Double.parseDouble(partes[4])
            );

            listaOriginal.add(nuevo);
            adaptador.actualizarLista(listaOriginal);
        }
    }
}