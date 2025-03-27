public class FoodTruck extends Restaurante {
    private String areaRecorrido;
    private String especialidad;
    private double costoMenuFijo;

    public FoodTruck(String nombre, String ubicacion, int capacidad, String tipoCocina, double calificacionMedia,
                     String areaRecorrido, String especialidad, double costoMenuFijo) {
        super(nombre, ubicacion, capacidad, tipoCocina, calificacionMedia);
        this.areaRecorrido = areaRecorrido;
        this.especialidad = especialidad;
        this.costoMenuFijo = costoMenuFijo;
    }

    @Override
    public double calcularIngresoEstimado() {
        return capacidad * costoMenuFijo * 0.5;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Food Truck");
        System.out.println("Área de recorrido: " + areaRecorrido);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Ingreso estimado: $" + calcularIngresoEstimado());
    }
}