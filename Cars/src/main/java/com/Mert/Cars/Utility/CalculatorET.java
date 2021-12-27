package com.Mert.Cars.Utility;
import com.Mert.Cars.Entity.CarEntity;
public class CalculatorET {
    public static double calculate(CarEntity carEntity, double carHp){
        double eTime;
        carEntity.carHp = carHp;
        double kg = carEntity.carKg;
        final double constant = 5.825;
        double division = kg / carHp;
        eTime=(Math.cbrt(division))*constant;
        return eTime;    }}
