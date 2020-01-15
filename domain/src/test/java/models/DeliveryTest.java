package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeliveryTest {

    private Drone drone;
    private List<Instruction> instructions;
    private List<DeliveryRoute> routes;
    private Delivery delivery;

    @Before
    public void setup(){
        drone = new Drone("000", 3);
        instructions = new ArrayList<>();
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        instructions.add(Instruction.I);
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        routes = new ArrayList<>();
        DeliveryRoute route = new DeliveryRoute(instructions);
        routes.add(route);
        delivery = new Delivery(routes, drone);
    }

    @Test
    public void runInstructions() {
        delivery.runInstructions(routes.get(0));
        Assert.assertEquals(-2, delivery.getDrone().getCoordinate().getX());
        Assert.assertEquals(4, delivery.getDrone().getCoordinate().getY());
        Assert.assertEquals(Orientation.West, delivery.getDrone().getCoordinate().getOrientation());
    }

    @Test
    public void go() {
        delivery.go();
        Assert.assertEquals(2, delivery.getDrone().getCapacity());
        Assert.assertEquals(1, delivery.getDeliveryReport().size());
        Assert.assertEquals("(-2,4) direccion = West",
                delivery.getDeliveryReport().get(0));
    }
}