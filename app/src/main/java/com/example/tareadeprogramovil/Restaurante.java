package com.example.tareadeprogramovil;

public class Restaurante {
    protected String nombre;
    protected String ubicacion;
    protected int capacidad;
    protected String tipoCocina;
    protected double calificacionMedia;
    protected int clientesServidos; // nuevo atributo

    public Restaurante(String nombre, String ubicacion, int capacidad, String tipoCocina,
                       double calificacionMedia, int clientesServidos) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipoCocina = tipoCocina;
        this.calificacionMedia = calificacionMedia;
        this.clientesServidos = clientesServidos;
    }

    public int getClientesServidos() {
        return clientesServidos;
    }

    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public String getTipoCocina() { return tipoCocina; }
    public double getCalificacionMedia() { return calificacionMedia; }


    public double calcularIngresoEstimado() {
        return 0.0; // Se sobreescribe en subclases
    }

    public String mostrarDetalles() {
        return "Nombre: " + nombre +
                "\nUbicación: " + ubicacion +
                "\nCapacidad: " + capacidad +
                "\nTipo de Cocina: " + tipoCocina +
                "\nCalificación Media: " + calificacionMedia +
                "\nClientes Servidos: " + clientesServidos;
    }
}