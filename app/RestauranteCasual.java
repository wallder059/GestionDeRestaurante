public class RestauranteCasual extends Restaurante {
    private boolean menuFijo;
    private double costoMenuFijo;

    public RestauranteCasual(String nombre, String ubicacion, int capacidad, String tipoCocina, double calificacionMedia,
                             boolean menuFijo, double costoMenuFijo) {
        super(nombre, ubicacion, capacidad, tipoCocina, calificacionMedia);
        this.menuFijo = menuFijo;
        this.costoMenuFijo = costoMenuFijo;
    }

    @Override
    public double calcularIngresoEstimado() {
        return capacidad * costoMenuFijo * 0.8;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Restaurante Casual");
        System.out.println("¿Menú fijo?: " + (menuFijo ? "Sí" : "No"));
        System.out.println("Costo del menú fijo: $" + costoMenuFijo);
        System.out.println("Ingreso estimado: $" + calcularIngresoEstimado());
    }
}