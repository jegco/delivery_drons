package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DroneTest {

    private Drone drone;

    @Before
    public void setup() {
        drone = new Drone("000", 3);
    }

    @Test
    public void rotateRightWhenOrientationIsNorth() {
        drone.rotateRight();
        Assert.assertEquals(Orientation.East, drone.getCoordinate().getOrientation());
    }

    @Test
    public void rotateRightWhenOrientationIsSouth() {
        drone.getCoordinate().setOrientation(Orientation.South);
        drone.rotateRight();
        Assert.assertEquals(Orientation.West, drone.getCoordinate().getOrientation());
    }

    @Test
    public void rotateRightWhenOrientationIsWest() {
        drone.getCoordinate().setOrientation(Orientation.West);
        drone.rotateRight();
        Assert.assertEquals(Orientation.North, drone.getCoordinate().getOrientation());
    }

    @Test
    public void rotateRightWhenOrientationIsEast() {
        drone.getCoordinate().setOrientation(Orientation.East);
        drone.rotateRight();
        Assert.assertEquals(Orientation.South, drone.getCoordinate().getOrientation());
    }

    @Test
    public void rotateLeftWhenOrientationIsNoth() {
        drone.rotateLeft();
        Assert.assertEquals(Orientation.West, drone.getCoordinate().getOrientation());
    }

    @Test
    public void rotateLeftWhenOrientationIsEast() {
        drone.getCoordinate().setOrientation(Orientation.East);
        drone.rotateLeft();
        Assert.assertEquals(Orientation.North, drone.getCoordinate().getOrientation());
    }

    @Test
    public void rotateLeftWhenOrientationIsWest() {
        drone.getCoordinate().setOrientation(Orientation.West);
        drone.rotateLeft();
        Assert.assertEquals(Orientation.South, drone.getCoordinate().getOrientation());
    }

    @Test
    public void rotateLeftWhenOrientationIsSouth() {
        drone.getCoordinate().setOrientation(Orientation.South);
        drone.rotateLeft();
        Assert.assertEquals(Orientation.East, drone.getCoordinate().getOrientation());
    }

    @Test
    public void moveForwardWhenOrientationIsNorth() {
        drone.moveForward();
        Assert.assertEquals(1, drone.getCoordinate().getY());
    }

    @Test
    public void moveForwardWhenOrientationIsSouth() {
        drone.getCoordinate().setOrientation(Orientation.South);
        drone.moveForward();
        Assert.assertEquals(-1, drone.getCoordinate().getY());
    }

    @Test
    public void moveForwardWhenOrientationIsWest() {
        drone.getCoordinate().setOrientation(Orientation.West);
        drone.moveForward();
        Assert.assertEquals(-1, drone.getCoordinate().getX());
    }

    @Test
    public void moveForwardWhenOrientationIsEast() {
        drone.getCoordinate().setOrientation(Orientation.East);
        drone.moveForward();
        Assert.assertEquals(1, drone.getCoordinate().getX());
    }
}