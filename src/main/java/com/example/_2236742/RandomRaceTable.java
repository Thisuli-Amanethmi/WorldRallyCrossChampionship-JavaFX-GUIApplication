package com.example._2236742;

public class RandomRaceTable {

    private int position;
    private String name;
    private int points;

    public RandomRaceTable(int position, String name, int points) {
        this.position = position;
        this.name = name;
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
