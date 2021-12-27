package com.Mert.Cars.Model;
import com.Mert.Cars.Enum.KgOfCar;
import com.Mert.Cars.Enum.TypeOfCar;
public class CarSedan implements CarInterface {
    @Override
    public String getCarType(){return TypeOfCar.SEDAN.getCarEnum();}
    @Override
    public double getKg(){
        return KgOfCar.SEDAN.getAttCarKg();
    }}
