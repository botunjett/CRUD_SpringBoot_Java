package com.Mert.Cars.Utility;
import com.Mert.Cars.Entity.CarEntity;
import com.Mert.Cars.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class CommandLineDemo implements CommandLineRunner {
    @Autowired
    public CarRepository carRepository;
    @Override
    public void run(String... args) throws Exception{
        CarEntity carEntity = new CarEntity();
        carEntity.setCarId(1);
        carEntity.setCarType("Sedan");
        carEntity.setCarKg(2000);
        carEntity.setCarHp(150);
        carRepository.save(carEntity);    }}
