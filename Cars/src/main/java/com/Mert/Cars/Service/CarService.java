package com.Mert.Cars.Service;
import java.util.ArrayList;
import java.util.List;
import com.Mert.Cars.Enum.TypeOfCar;
import com.Mert.Cars.Exception.ApiRequestException;
import com.Mert.Cars.Model.CarInterface;
import com.Mert.Cars.Utility.CalculatorET;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.Mert.Cars.Entity.CarEntity;
import com.Mert.Cars.Repository.CarRepository;
import com.Mert.Cars.Factory.CarFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
@Service
@RequiredArgsConstructor
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public List<CarEntity> getAllCars(){
        List<CarEntity> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;    }
    public CarEntity getCarsById(int id){
        return carRepository.findById(id).
                orElseThrow(()-> new ApiRequestException("Id bulunamadı veya çoktan silinmiş"));    }
    public CarEntity createCar(String carTypeFromUser, double carHpFromUser){
        CarEntity carEntity = new CarEntity();
        CarFactory carFactory = new CarFactory();
        CarInterface carInterface = carFactory.getCar(carTypeFromUser);
        carEntity.carHp=carHpFromUser;
        carEntity.carType=carInterface.getCarType();
        carEntity.carKg=carInterface.getKg();
        carEntity.carZeroToHundred=CalculatorET.calculate(carEntity,carHpFromUser);
        carRepository.save(carEntity);
        return carEntity;    }
    public CarEntity updateCar(int carIdFromUser, String carTypeFromUser,double carHpFromUser){
        CarFactory carFactory = new CarFactory();
        CarEntity carEntity = new CarEntity();
        CarInterface carInterface = carFactory.getCar(carTypeFromUser);
        carEntity.carId = carIdFromUser;
        carEntity.carHp= carHpFromUser;
        carEntity.carType=carInterface.getCarType();
        carEntity.carKg=carInterface.getKg();
        carEntity.carZeroToHundred=CalculatorET.calculate(carEntity,carHpFromUser);
        if(carEntity.carType.equals(TypeOfCar.SEDAN.getCarEnum())&& carRepository.findById(carEntity.carId).isPresent()
            || carEntity.carType.equals(TypeOfCar.HATCHBACK.getCarEnum())&&carRepository.findById(carEntity.carId).isPresent()
                || carEntity.carType.equals(TypeOfCar.STATION.getCarEnum())&&carRepository.findById(carEntity.carId).isPresent())
        {
            carRepository.save(carEntity);
        }
        else {
            throw new ApiRequestException("Yalnızca var olan bir ID'yi Sedan, Station veya Hatchback olarak değiştirebilirsiniz");
        }
        return carEntity;    }
    public void deleteCar(int id){
        if(carRepository.findById(id).isPresent()){
            carRepository.deleteById(id);}
            else{
                throw new ApiRequestException("ID çoktan silinmiş veya bulunamadı.");     }        }    }

