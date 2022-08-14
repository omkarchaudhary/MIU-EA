package com.miu.ea.cs544.exam3.repository;

import com.miu.ea.cs544.exam3.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "select * from car c join driver d on c.driver_id =  d.id and d.experience > 3 ", nativeQuery = true)
    public List<Car> getCarByExperince();

    @Query(value = "select * from car c join driver d on c.driver_id = d.id join Owner o on c.owner_id = o.id", nativeQuery = true)
    public List<Car> getCarWithOwnerIowa();
    @Query(value = "select * from car c order by c.price desc limit 1", nativeQuery = true)
    public Car mostExpensiveCar();
}
