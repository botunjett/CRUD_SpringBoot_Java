package com.Mert.Cars.Repository;
import com.Mert.Cars.Entity.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CarRepository extends JpaRepository<CarEntity,Integer> {}
