import java.util.ArrayList;
import java.util.List;

public class ControladorRestaurante {
    private List<Restaurante> listaRestaurantes;

    public ControladorRestaurante() {
        listaRestaurantes = new ArrayList<>();

        // Agregamos uno de cada tipo
        listaRestaurantes.add(new RestauranteCasual("Casualito", "Centro", 50, "Mexicana", 4.2, true, 12.5));
        listaRestaurantes.add(new RestauranteGourmet("GourmetChef", "Zona Alta", 30, "Francesa", 4.8, 5, 50));
        listaRestaurantes.add(new FoodTruck("Rápido y Sabroso", "Calles del centro", 20, "Street Food", 4.0, "Zona Norte", "Tacos", 8.0));
    }

    public List<Restaurante> getListaRestaurantes() {
        return listaRestaurantes;
    }
}