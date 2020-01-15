package models;

public class Coordinate {
    private int x;
    private int y;
    private Orientation orientation;

    Coordinate() {
        this.x = 0;
        this.y = 0;
        this.orientation = Orientation.North;
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    Orientation getOrientation() {
        return orientation;
    }

    void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ") direccion = " + orientation;
    }
}
