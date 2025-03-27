package com.example.tareadeprogramovil;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {
    private List<Restaurante> lista;

    public RestauranteAdapter(List<Restaurante> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurante, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurante r = lista.get(position);
        holder.tvNombre.setText(r.getNombre());
        holder.tvTipo.setText("Ubicación: " + r.getUbicacion() + " | Cocina: " + r.getTipoCocina());
        holder.tvIngreso.setText("Ingreso estimado: $" + r.calcularIngresoEstimado());

        // Evento al hacer clic en cada elemento:
        holder.itemView.setOnClickListener(v -> {
            new AlertDialog.Builder(v.getContext())
                    .setTitle(r.getNombre())
                    .setMessage(r.mostrarDetalles())
                    .setPositiveButton("Cerrar", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void actualizarLista(List<Restaurante> nuevaLista) {
        lista = nuevaLista;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvTipo, tvIngreso;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            tvIngreso = itemView.findViewById(R.id.tvIngreso);
        }
    }
}
