package com.miu.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;

    @GetMapping(path = "/read")
    public List<Product> readProduct(){
         return productRepository.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteHouse(@PathVariable int id){
        //Optional<Product> product = productRepository.findById(id);
        productRepository.deleteById(id);
        return "The product is deleted";
    }
    @GetMapping(value = "/product/{value}")
    public List<Product> getProductGreateThan(@PathVariable int value){
       return productRepository.findProductsByPriceGreaterThan(value);
    }

    @GetMapping(path = "/hello")
    public String getGreetingMessage(){
        return resourceBundleMessageSource.getMessage("hello.world.message", null, LocaleContextHolder.getLocale());
    }
}
