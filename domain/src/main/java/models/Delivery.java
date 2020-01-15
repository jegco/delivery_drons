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

    public Delivery go() {
        for (DeliveryRoute deliveryRoute : getDeliveryOrder()) {
            runInstructions(deliveryRoute);
            drone = drone.updateDroneDeliveriesLeft();
            deliveryReport.add(drone.toString());
        }
        return this;
    }

    void runInstructions(DeliveryRoute instructions) {
        instructions.getRoutes().forEach(instruction -> {
            if (instruction != null)
                switch (instruction) {
                    case A:
                        drone.moveForward();
                        break;
                    case D:
                        drone.rotateRight();
                        break;
                    case I:
                        drone.rotateLeft();
                        break;
                }
        });
    }

    public List<DeliveryRoute> getDeliveryOrder() {
        return deliveryOrder;
    }

    public Drone getDrone() {
        return drone;
    }

    public List<String> getDeliveryReport() {
        return deliveryReport;
    }
}
