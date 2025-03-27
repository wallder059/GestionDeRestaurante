package com.example.tareadeprogramovil;

public class RestauranteCasual extends Restaurante {
    private boolean menuFijo;
    private double costoMenuFijo;

    public RestauranteCasual(String nombre, String ubicacion, int capacidad, String tipoCocina, double calificacionMedia,
                             boolean menuFijo, double costoMenuFijo,int clientesServidos) {
        super(nombre, ubicacion, capacidad, tipoCocina, calificacionMedia,clientesServidos);
        this.menuFijo = menuFijo;
        this.costoMenuFijo = costoMenuFijo;
    }

    @Override
    public double calcularIngresoEstimado() {
        return capacidad * costoMenuFijo * 0.8;
    }
    @Override
    public String mostrarDetalles() {
        return super.mostrarDetalles() +
                "\nMenú Fijo: " + (menuFijo ? "Sí" : "No") +
                "\nCosto Menú Fijo: $" + costoMenuFijo +
                "\nIngreso Estimado: $" + calcularIngresoEstimado();
    }
}