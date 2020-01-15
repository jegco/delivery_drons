package models;

import java.util.List;
import java.util.stream.Collectors;

public class DeliveryRoute {
    private List<String> options;

    public DeliveryRoute(String route) {
        this.options = route.chars()
                .mapToObj(c -> Character.toString((char)c))
                .collect(Collectors.toList());
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        for (String option: options) {
            aux.append(option);
        }
        return "Ruta de entrega " + aux;
    }
}
