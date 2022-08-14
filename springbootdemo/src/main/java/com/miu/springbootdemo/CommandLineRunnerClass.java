package com.miu.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerClass implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        create();
        read();
        update();
        deleteById(1);
        System.out.println("Product with price greater than 200000:");
        System.out.println(productRepository.findProductsByPriceGreaterThan(200000));
        System.out.println("Product build at year 1998:");
        System.out.println(productRepository.findProductsByYearEquals(1998));
        System.out.println("Product expensive house:");
        System.out.println(productRepository.findDistinctFirstByPrice());

    }

    private void deleteById(int id) {
        System.out.println("Delete operation");
        productRepository.deleteById(id);
    }

    private void update() {
        System.out.println("Update operation");
        Product product = productRepository.findById(1).get();
        product.setPrice(450000);
        productRepository.save(product);
    }

    private void read() {
        System.out.println("Read operation");
        Product product = productRepository.findById(1).get();
        System.out.println(product);
    }

    private void create() {
        System.out.println("Create operation");
        productRepository.save(new Product(1997, 550000));
        productRepository.save(new Product(1998, 200000));
        productRepository.save(new Product(1999, 100000));
        productRepository.save(new Product(2000, 150000));
        productRepository.save(new Product(1996, 550000));
        productRepository.save(new Product(1997, 550000));
    }
}
