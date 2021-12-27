package com.Mert.Cars.Enum;
public enum TypeOfCar {
    SEDAN ("Sedan"),
    STATION ("Station"),
    HATCHBACK ("Hatchback");
    private final String carEnum;
    TypeOfCar(String carEnum){
        this.carEnum = carEnum;
    }
    public String getCarEnum(){return carEnum;}}
