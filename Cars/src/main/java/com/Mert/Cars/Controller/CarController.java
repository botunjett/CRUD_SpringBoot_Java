package com.Mert.Cars.Controller;
import java.util.List;
import com.Mert.Cars.Model.CarInterface;
import com.Mert.Cars.Model.CarModel;
import com.Mert.Cars.Utility.CalculatorET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Mert.Cars.Entity.CarEntity;
import com.Mert.Cars.Service.CarService;
@RestController
public class CarController {
    @Autowired
    public CarService carService;
    @GetMapping("/car")
    public List<CarEntity> getAllCars(){
        return carService.getAllCars();    }
    @GetMapping("/car/{carId}")
    public CarEntity getCars(@PathVariable("carId")int carId){
        return carService.getCarsById(carId);    }
    @DeleteMapping("/car/{carId}")
    public List<CarEntity> deleteCar(@PathVariable("carId")int carId){
        carService.deleteCar(carId);
        return carService.getAllCars();    }
    @PostMapping(path = "/cars")
    public CarEntity saveCar(@RequestBody CarModel carModel){
        return carService.createCar(carModel.getCarType(),carModel.getCarHp());    }
    @PutMapping(path = "/updateCar")
    public CarEntity updateCar(@RequestBody CarModel carModel){
        return carService.updateCar(carModel.getCarId(),carModel.getCarType(),carModel.getCarHp());    }}
