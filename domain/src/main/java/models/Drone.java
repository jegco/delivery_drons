package models;

public class Drone {
    private String id;
    private int capacity;
    private Coordinate coordinate;

    public Drone(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.coordinate = new Coordinate();
    }

    public Drone(String id, int capacity, Coordinate coordinate) {
        this.id = id;
        this.capacity = capacity;
        this.coordinate = coordinate;
    }

    public void rotateRight() {
        switch (coordinate.getOrientation()){
            case North:
                coordinate.setOrientation(Orientation.East);
                break;
            case East:
                coordinate.setOrientation(Orientation.South);
                break;
            case West:
                coordinate.setOrientation(Orientation.North);
                break;
            case South:
                coordinate.setOrientation(Orientation.West);
                break;

        }
    }

    public void rotateLeft() {
        switch (coordinate.getOrientation()){
            case North:
                coordinate.setOrientation(Orientation.West);
                break;
            case East:
                coordinate.setOrientation(Orientation.North);
                break;
            case West:
                coordinate.setOrientation(Orientation.South);
                break;
            case South:
                coordinate.setOrientation(Orientation.East);
                break;

        }
    }

    public void moveForward() {
        switch (coordinate.getOrientation()){
            case North:
                coordinate.setY(coordinate.getY() + 1);
                break;
            case East:
                coordinate.setX(coordinate.getX() + 1);
                break;
            case West:
                coordinate.setX(coordinate.getX() - 1);
                break;
            case South:
                coordinate.setY(coordinate.getY() - 1);
                break;

        }
    }

    public int getCapacity() {
        return capacity;
    }

    public Drone updateDroneDeliveriesLeft() {
        return new Drone(this.id, this.capacity - 1, this.coordinate);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return coordinate.toString();
    }
}
