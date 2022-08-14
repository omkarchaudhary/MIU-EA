package com.miu.springbootdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.price > ?1")
    public List<Product> findProductsByPriceGreaterThan(int price);
    @Query("select p from Product p where p.years = ?1")
    public List<Product> findProductsByYearEquals(int year);
    @Query(value = "select * from Product p oer by p.price desc limit 1",nativeQuery = true)
    public Product findDistinctFirstByPrice();
}
