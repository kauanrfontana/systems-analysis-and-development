package org.example;

public class ExplorerRobot {
    private String name;
    private Coordinate coordinate;
    private int angle;
    private int battery;

    public ExplorerRobot(String name, int x, int y, int angle, int battery) {
        this.name = name;
        this.coordinate = new Coordinate(x, y);
        this.angle = angle;
        this.battery = battery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int x, int y) {
        this.coordinate = new Coordinate(x, y);
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }
}
