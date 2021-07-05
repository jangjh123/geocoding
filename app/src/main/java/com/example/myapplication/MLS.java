package com.example.myapplication;

public class MLS {
    private String name;
    private double distance;
    private String date;

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public String getDate() {
        return date;
    }

    public MLS(String name, double distance, String date) {
        this.name = name;
        this.distance = distance;
        this.date = date;
    }
}
