package com.example.tareadeprogramovil;

public class FoodTruck extends Restaurante {
    private String areaRecorrido;
    private String especialidad;
    private double costoMenuFijo;

    public FoodTruck(String nombre, String ubicacion, int capacidad, String tipoCocina, double calificacionMedia,
                     String areaRecorrido, String especialidad, double costoMenuFijo,int clientesServidos) {
        super(nombre, ubicacion, capacidad, tipoCocina, calificacionMedia, clientesServidos);
        this.areaRecorrido = areaRecorrido;
        this.especialidad = especialidad;
        this.costoMenuFijo = costoMenuFijo;
    }

    @Override
    public double calcularIngresoEstimado() {
        return capacidad * costoMenuFijo * 0.5;
    }

    @Override
    public String mostrarDetalles() {
        return super.mostrarDetalles() +
                "\nÁrea de Recorrido: " + areaRecorrido +
                "\nEspecialidad: " + especialidad +
                "\nCosto Menú Fijo: $" + costoMenuFijo +
                "\nIngreso Estimado: $" + calcularIngresoEstimado();
    }
}

