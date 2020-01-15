package models;

public enum Orientation {
    North("N", "North"),
    South("S", "South"),
    West("W", "West"),
    East("E", "East");

    private final String abbreviation;
    private final String direction;

    Orientation(String abbreviation, String direction) {
        this.abbreviation = abbreviation;
        this.direction = direction;
    }

    public Orientation getOrientationByAbbreviation(String abbreviation) {
        for (Orientation orientation : values()) {
            if (orientation.getAbbreviation().equalsIgnoreCase(abbreviation)) {
                return orientation;
            }
        }
        return null;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
