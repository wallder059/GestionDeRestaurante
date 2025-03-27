package com.example.tareadeprogramovil;

public class RestauranteGourmet extends Restaurante {
    private int numeroPlatosExclusivos;
    private double costoDegustacion;

    public RestauranteGourmet(String nombre, String ubicacion, int capacidad, String tipoCocina, double calificacionMedia,
                              int numeroPlatosExclusivos, double costoDegustacion,int clientesServidos) {
        super(nombre, ubicacion, capacidad, tipoCocina, calificacionMedia, clientesServidos);
        this.numeroPlatosExclusivos = numeroPlatosExclusivos;
        this.costoDegustacion = costoDegustacion;
    }

    @Override
    public double calcularIngresoEstimado() {
        return capacidad * costoDegustacion * 0.6;
    }

    @Override
    public String mostrarDetalles() {
        return super.mostrarDetalles() +
                "\nPlatos Exclusivos: " + numeroPlatosExclusivos +
                "\nCosto Degustación: $" + costoDegustacion +
                "\nIngreso Estimado: $" + calcularIngresoEstimado();
    }
}

