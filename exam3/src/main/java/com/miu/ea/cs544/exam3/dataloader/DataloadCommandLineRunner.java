package com.miu.ea.cs544.exam3.dataloader;

import com.miu.ea.cs544.exam3.entities.Address;
import com.miu.ea.cs544.exam3.entities.Car;
import com.miu.ea.cs544.exam3.entities.Driver;
import com.miu.ea.cs544.exam3.entities.Owner;
import com.miu.ea.cs544.exam3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
@Transactional
public class DataloadCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CarRepository carRepository;
    @Override
    public void run(String... args) throws Exception {
        create();
        read();
        update();
        deletebyId(1);
        System.out.println("The list of car having driver experience of 3 years "+ carRepository.getCarByExperince());
        System.out.println("The most expensive car "+ carRepository.mostExpensiveCar());
        System.out.println("The car whose owner in Iowa "+ carRepository.getCarWithOwnerIowa());
    }
    private void create(){
        System.out.println("Create Operation ");
        Address address = new Address("fairfield","fairfield","Iowa","52557");

        Driver driver = new Driver();
        driver.setName("Driver");
        driver.setBirthdate(LocalDate.of(1990,11,1));
        driver.setExperience(2);

        Owner owner = new Owner();
        owner.setAddress(address);
        owner.setName("John");
        owner.setBirthdate(LocalDate.of(1990,11,1));
        owner.setExperience(3);

        Car car = new Car(2010,35000,100,owner,driver);
        carRepository.save(car);
    }
    private void read(){
        System.out.println("Read operation ");
        Car car = carRepository.findById(1l).get();
        System.out.println(car);
    }
    private void update(){
        System.out.println("update operation ");
        Car car = carRepository.findById(1l).get();
        car.setPrice(25000);
    }
    private void deletebyId(long id){
        System.out.println("delete operation ");
        carRepository.deleteById(id);
    }
}
