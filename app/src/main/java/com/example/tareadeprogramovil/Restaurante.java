package com.example.tareadeprogramovil;

public class Restaurante {
    protected String nombre;
    protected String ubicacion;
    protected int capacidad;
    protected String tipoCocina;
    protected double calificacionMedia;

    public Restaurante(String nombre, String ubicacion, int capacidad, String tipoCocina, double calificacionMedia) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipoCocina = tipoCocina;
        this.calificacionMedia = calificacionMedia;
    }

    public double calcularIngresoEstimado() {
        return 0.0;
    }

    public String mostrarDetalles() {
        return "Nombre: " + nombre +
                "\nUbicación: " + ubicacion +
                "\nCapacidad: " + capacidad +
                "\nTipo de Cocina: " + tipoCocina +
                "\nCalificación Media: " + calificacionMedia;
    }

    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public String getTipoCocina() { return tipoCocina; }
}