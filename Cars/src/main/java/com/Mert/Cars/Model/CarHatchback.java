package com.Mert.Cars.Model;
import com.Mert.Cars.Enum.KgOfCar;
import com.Mert.Cars.Enum.TypeOfCar;
public class CarHatchback implements CarInterface {
    @Override
    public String getCarType(){return TypeOfCar.HATCHBACK.getCarEnum();}
    @Override
    public double getKg(){
        return KgOfCar.HATCHBACK.getAttCarKg();    }}