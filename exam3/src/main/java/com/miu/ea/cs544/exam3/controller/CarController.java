package com.miu.ea.cs544.exam3.controller;

import com.miu.ea.cs544.exam3.entities.Car;
import com.miu.ea.cs544.exam3.entities.Driver;
import com.miu.ea.cs544.exam3.jms.Sender;
import com.miu.ea.cs544.exam3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private Sender sender;
    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;

    @GetMapping(path = "getlistofcar")
    public List<Car> getListOfCar(){
        return carRepository.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCar(@PathVariable long id){
        carRepository.deleteById(id);
    }

    @PutMapping(path = "/updatecar/{id}")
    public void updateDriver(@PathVariable long id, @RequestBody Driver driver){
        Car car = carRepository.findById(id).get();
        car.setDriver(driver);
        carRepository.save(car);
        sender.send(driver.toString());
    }

    @GetMapping(path = "/hello")
    public String greetingMessage(){
        return resourceBundleMessageSource.getMessage("greeting.message",null, LocaleContextHolder.getLocale());
    }
}
