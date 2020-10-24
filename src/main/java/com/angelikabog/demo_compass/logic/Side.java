package com.angelikabog.demo_compass.logic;

public class Side {
    private String north;
    private String northeast;
    private String northwest;
    private String south;
    private String southeast;
    private String southwest;
    private String east;
    private String west;

    public Side(String north, String northeast, String northwest, String south, String southeast, String southwest, String east, String west) {
        this.north = north;
        this.northeast = northeast;
        this.northwest = northwest;
        this.south = south;
        this.southeast = southeast;
        this.southwest = southwest;
        this.east = east;
        this.west = west;
    }

    public Side(){}

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getNortheast() {
        return northeast;
    }

    public void setNortheast(String northeast) {
        this.northeast = northeast;
    }

    public String getNorthwest() {
        return northwest;
    }

    public void setNorthwest(String northwest) {
        this.northwest = northwest;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getSoutheast() {
        return southeast;
    }

    public void setSoutheast(String southeast) {
        this.southeast = southeast;
    }

    public String getSouthwest() {
        return southwest;
    }

    public void setSouthwest(String southwest) {
        this.southwest = southwest;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }
}
