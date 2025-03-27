package com.example.tareadeprogramovil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
        Button btnResumen = findViewById(R.id.btnResumen);

        // Crear restaurantes de ejemplo
        listaOriginal = new ArrayList<>();
        listaOriginal.add(new RestauranteCasual("Casualito", "Centro", 40, "Mexicana", 4.2, true, 10, 80));
        listaOriginal.add(new RestauranteCasual("Comida Rápida", "Sur", 30, "Italiana", 4.0, false, 12, 50));
        listaOriginal.add(new RestauranteGourmet("GourmetChef", "Zona Alta", 20, "Francesa", 4.8, 5, 60, 100));
        listaOriginal.add(new RestauranteGourmet("DeluxeTaste", "Norte", 25, "Mediterránea", 4.6, 4, 55, 75));
        listaOriginal.add(new FoodTruck("Rápido y Sabroso", "Calles", 30, "Tacos", 4.1, "Centro", "Carnitas", 8, 121));
        listaOriginal.add(new FoodTruck("La Carreta", "Av. Siempre Viva", 35, "Hamburguesas", 3.9, "Sur", "Cheddar Bacon", 10, 100));
        listaOriginal.add(new RestauranteCasual("Sabores Urbanos", "Centro", 45, "Boliviana", 4.3, true, 9, 95));
        listaOriginal.add(new RestauranteGourmet("Alta Cocina", "Zona Sur", 18, "Japonesa", 4.9, 6, 70, 110));
        listaOriginal.add(new FoodTruck("El Camión Verde", "Mercado", 28, "Vegana", 4.0, "Centro", "Tofu BBQ", 9, 60));
        listaOriginal.add(new RestauranteCasual("BurgersXpress", "Miraflores", 50, "Americana", 4.1, true, 11, 85));

        adaptador = new RestauranteAdapter(listaOriginal);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adaptador);

        btnAgregar.setOnClickListener(v -> {
            Intent i = new Intent(ListaActivity.this, AgregarRestauranteActivity.class);
            startActivityForResult(i, REQUEST_CODE_NUEVO);
        });

        btnResumen.setOnClickListener(v -> mostrarResumenClientesServidos());

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

    private void mostrarResumenClientesServidos() {
        Toast.makeText(this, "Generando resumen...", Toast.LENGTH_SHORT).show();

        int totalCasual = 0, totalGourmet = 0, totalFoodTruck = 0;

        for (Restaurante r : listaOriginal) {
            if (r instanceof RestauranteCasual) {
                totalCasual += r.getClientesServidos();
            } else if (r instanceof RestauranteGourmet) {
                totalGourmet += r.getClientesServidos();
            } else if (r instanceof FoodTruck) {
                totalFoodTruck += r.getClientesServidos();
            }
        }

        String resumen = "Resumen de Clientes Servidos:\n" +
                "Casual: " + totalCasual + "\n" +
                "Gourmet: " + totalGourmet + "\n" +
                "FoodTruck: " + totalFoodTruck;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resumen por Tipo");
        builder.setMessage(resumen);
        builder.setPositiveButton("Cerrar", null);
        builder.show();
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
                    Double.parseDouble(partes[4]),
                    Integer.parseInt(partes[5]
                    )
            );

            listaOriginal.add(nuevo);
            adaptador.actualizarLista(listaOriginal);
        }
    }
}