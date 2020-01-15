package models;

public class Drone {
    private String id;
    private int capacity;
    private Coordinate coordinate;

    public Drone(String id, int capacity, Coordinate coordinate) {
        this.id = id;
        this.capacity = capacity;
        this.coordinate = coordinate;
    }

    public Drone(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.coordinate = new Coordinate();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "Dron con id=" + id +
                " tiene " + capacity +
                " pedidos y esta en la coordenada " + coordinate.toString();
    }
}
