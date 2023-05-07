package com.example._2236742;

public class RaceTable {
    private String date;
    private String location;

    public RaceTable(String date, String location) {
        this.date = date;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
