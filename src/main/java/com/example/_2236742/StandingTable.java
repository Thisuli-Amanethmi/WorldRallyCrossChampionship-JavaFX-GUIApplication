package com.example._2236742;

public class StandingTable {
    private String name;
    private int age;
    private String car;
    private String team;
    private int currentPoints;

    public StandingTable(String name, int age, String car, String team, int currentPoints) {
        this.name = name;
        this.age = age;
        this.car = car;
        this.team = team;
        this.currentPoints = currentPoints;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCar() {
        return car;
    }

    public String getTeam() {
        return team;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }
}