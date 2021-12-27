package com.Mert.Cars.Factory;
import com.Mert.Cars.Enum.KgOfCar;
import com.Mert.Cars.Enum.TypeOfCar;
import com.Mert.Cars.Exception.ApiRequestException;
import com.Mert.Cars.Model.*;
public class CarFactory {
    public CarInterface getCar(String carType){
        if(carType.equals(TypeOfCar.SEDAN.getCarEnum())){
            return new CarSedan();
        }else if(carType.equals((TypeOfCar.STATION.getCarEnum()))){
            return new CarStation();
        }else if(carType.equals(TypeOfCar.HATCHBACK.getCarEnum())){
            return new CarHatchback();
        }else{ throw new ApiRequestException("Yalnızca Sedan, Station veya Hatchback girebilirsiniz");        }    }}
