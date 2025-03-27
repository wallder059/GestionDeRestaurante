public class RestauranteGourmet extends Restaurante {
    private int numeroPlatosExclusivos;
    private double costoDegustacion;

    public RestauranteGourmet(String nombre, String ubicacion, int capacidad, String tipoCocina, double calificacionMedia,
                              int numeroPlatosExclusivos, double costoDegustacion) {
        super(nombre, ubicacion, capacidad, tipoCocina, calificacionMedia);
        this.numeroPlatosExclusivos = numeroPlatosExclusivos;
        this.costoDegustacion = costoDegustacion;
    }

    @Override
    public double calcularIngresoEstimado() {
        return capacidad * costoDegustacion * 0.6;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Restaurante Gourmet");
        System.out.println("Número de platos exclusivos: " + numeroPlatosExclusivos);
        System.out.println("Costo de degustación: $" + costoDegustacion);
        System.out.println("Ingreso estimado: $" + calcularIngresoEstimado());
    }
}