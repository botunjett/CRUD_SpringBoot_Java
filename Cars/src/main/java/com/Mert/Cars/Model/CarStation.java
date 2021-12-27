package com.Mert.Cars.Model;
import com.Mert.Cars.Enum.KgOfCar;
import com.Mert.Cars.Enum.TypeOfCar;
public class CarStation implements CarInterface {
    @Override
    public String getCarType(){return TypeOfCar.STATION.getCarEnum();}
    @Override
    public double getKg(){
        return KgOfCar.STATION.getAttCarKg();
    }}