package com.Mert.Cars.Enum;
public enum KgOfCar {
    SEDAN (1200),
    STATION(2000),
    HATCHBACK(1500);
    private final double carEnum;
    KgOfCar(double carEnum){
        this.carEnum=carEnum;
    }
    public double getAttCarKg(){return carEnum;}}
