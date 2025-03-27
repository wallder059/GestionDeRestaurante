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
            return 0.0; // Será sobrescrito por cada subclase
        }

        public void mostrarDetalles() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Ubicación: " + ubicacion);
            System.out.println("Capacidad: " + capacidad);
            System.out.println("Tipo de cocina: " + tipoCocina);
            System.out.println("Calificación media: " + calificacionMedia);
        }

        public double getCalificacionMedia() {
            return calificacionMedia;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        public String getTipoCocina() {
            return tipoCocina;
        }
    }

