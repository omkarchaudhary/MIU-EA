package com.miu.jobsearch.controller;

import com.miu.jobsearch.entities.Client;
import com.miu.jobsearch.entities.Company;
import com.miu.jobsearch.entities.Recruiter;
import com.miu.jobsearch.jms.JobSender;
import com.miu.jobsearch.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private JobSender jobSender;

    @GetMapping(path = "/company")
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping(path = "/company/{id}")
    public Company getCompany(@PathVariable int id){
        return companyService.getCompany(id);
    }

    @PostMapping(path = "/recruiter")
    public ResponseEntity<?> createRecruiter(@RequestBody Recruiter recruiter) {
        return new ResponseEntity<>(companyService.create(recruiter), HttpStatus.OK);
    }

    @PostMapping(path = "/client")
    public ResponseEntity<?> createClient(@RequestBody Client client) {

        return new ResponseEntity<>(jobSender.send(client), HttpStatus.OK);
//        return new ResponseEntity<>(companyService.create(client), HttpStatus.OK);

    }

    @PutMapping(path = "/recruiter")
    public ResponseEntity<?> updateRecruiter(@RequestBody Recruiter recruiter) {
        return new ResponseEntity<>(companyService.update(recruiter), HttpStatus.OK);
    }

    @PutMapping(path = "/client")
    public ResponseEntity<?> updateClient(@RequestBody Recruiter recruiter) {
        return new ResponseEntity<>(companyService.update(recruiter), HttpStatus.OK);
    }

    @DeleteMapping("/company/{id}")
    public void deleteCompany(@PathVariable int id){
        companyService.delete(id);
    }

    @GetMapping(path = "/company/state/{name}")
    public List<Company> findCompaniesByAddressInGivenState(@PathVariable String name){
         return companyService.findCompaniesByAddressInGivenState(name);
    }

}
