package com.miu.jobsearch.controller;

import com.miu.jobsearch.entities.Address;
import com.miu.jobsearch.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping(path = "/address")
    public ResponseEntity<?> createApplication(@RequestBody Address address){
        return new ResponseEntity<>(addressService.create(address), HttpStatus.OK);
    }
}
