package models;

import java.util.ArrayList;
import java.util.List;

public class Delivery {
    private List<DeliveryRoute> deliveryOrder;
    private Drone drone;
    private List<String> deliveryReport;

    public Delivery(List<DeliveryRoute> deliveryOrder, Drone drone) {
        this.deliveryOrder = deliveryOrder;
        this.drone = drone;
        this.deliveryReport = new ArrayList<>();
    }

    public List<DeliveryRoute> getDeliveryOrder() {
        return deliveryOrder;
    }

    public void setDeliveryOrder(List<DeliveryRoute> deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public List<String> getDeliveryReport() {
        return deliveryReport;
    }
}
