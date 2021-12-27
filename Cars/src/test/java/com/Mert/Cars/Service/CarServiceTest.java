package com.Mert.Cars.Service;
import com.Mert.Cars.Entity.CarEntity;
import com.Mert.Cars.Exception.ApiRequestException;
import com.Mert.Cars.Repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.ArgumentMatchers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.junit.Assert.assertEquals;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
    @Mock
    private  CarRepository carRepository;
    @InjectMocks
    private CarService carService;
    @Test
    public void getAllCars() {
        List<CarEntity> cars = new ArrayList<>();
        CarEntity entity1 = new CarEntity();
        entity1.setCarHp(1000);
        cars.add(entity1);
        given(carRepository.findAll()).willReturn(cars);
        List<CarEntity> expected = carService.getAllCars();
        assertEquals(expected,cars);
        verify(carRepository).findAll();    }
    @Test
    public void getCarsById() {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarId(87);
        when(carRepository.findById(anyInt())).thenReturn(Optional.of(carEntity));
        CarEntity expected = carService.getCarsById(carEntity.getCarId());
        assertThat(expected).isSameAs(carEntity);
        verify(carRepository).findById(carEntity.getCarId());    }
    @Test(expected = ApiRequestException.class)
    public void shouldThrowExceptionWhenCarDoesntExist(){
        CarEntity carEntity = new CarEntity();
        carEntity.setCarId(44);
        carEntity.setCarType("Sedan");
        given(carRepository.findById(anyInt())).willReturn(Optional.ofNullable(null));
        carService.getCarsById(carEntity.getCarId());    }
    @Test
    public void createCar() {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarType("Sedan");
        when(carRepository.save(ArgumentMatchers.any(CarEntity.class))).thenReturn(carEntity);
        CarEntity created = carService.createCar(carEntity.carType,carEntity.carHp);
        assertThat(created.getCarType()).isSameAs(carEntity.getCarType());
        verify(carRepository).save(carEntity);    }
    @Test(expected = ApiRequestException.class)
    public void updateCar() {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarId(33);
        carEntity.setCarType("Hatchback");
        CarEntity newEntity = new CarEntity();
        newEntity.setCarType("Sedan");
        given(carRepository.findById(carEntity.getCarId())).willReturn(Optional.of(carEntity));
        carService.updateCar(newEntity.carId,newEntity.carType,newEntity.carHp);
        verify(carRepository).save(newEntity);
        verify(carRepository).findById(carEntity.getCarId());    }
    @Test
    public void deleteCar() {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarType("Sedan");
        carEntity.setCarId(1);
        when(carRepository.findById(carEntity.getCarId())).thenReturn(Optional.of(carEntity));
        carService.deleteCar(carEntity.getCarId());
        verify(carRepository).deleteById(carEntity.getCarId());    }
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenIdDoesntExist(){
        CarEntity carEntity = new CarEntity();
        carEntity.setCarId(88);
        carEntity.setCarType("Sedan");
        given(carRepository.findById(anyInt())).willReturn(Optional.ofNullable(null));
        carService.deleteCar(carEntity.getCarId());    }}