package com.Mert.Cars.Entity;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class CarEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int carId;
    @Column
    public String carType;
    @Column
    public double carKg;
    @Column
    public double carHp;
    @Column
    public double carZeroToHundred;
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(carId,carEntity.carId);    }
    @Override
    public int hashCode(){return 1286466002;}}
