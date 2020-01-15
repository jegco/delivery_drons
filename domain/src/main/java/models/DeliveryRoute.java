package models;

import java.util.List;
import java.util.stream.Collectors;

public class DeliveryRoute {
    private List<Instruction> routes;

    public DeliveryRoute(List<Instruction> routes) {
        this.routes = routes;
    }

    public List<Instruction> getRoutes() {
        return routes;
    }
}
