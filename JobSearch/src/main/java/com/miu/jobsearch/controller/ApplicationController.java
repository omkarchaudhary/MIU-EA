package com.miu.jobsearch.controller;

import com.miu.jobsearch.entities.Application;
import com.miu.jobsearch.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping(path = "/application")
    public List<Application> getAllApplications(){
        return applicationService.getAllApplication();
    }


    @GetMapping(path = "/application/{applicationId}")
    public Application getApplication(@PathVariable int applicationId){
        return applicationService.getApplication(applicationId);
    }

    @PostMapping(path = "/application")
    public ResponseEntity<?> createApplication(@RequestBody Application application){
        return new ResponseEntity<>(applicationService.create(application), HttpStatus.OK);
    }

    @PutMapping(path = "/application")
    public ResponseEntity<?> updateApplication(@RequestBody Application application){
        return new ResponseEntity<>(applicationService.update(application), HttpStatus.OK);
    }

    @DeleteMapping(path = "/application/{applicationId}")
    public void deleteApplication(@PathVariable int applicationId){
        applicationService.delete(applicationId);
    }

    @GetMapping(path = "/application/job/{jobName}")
    public List<Application> findApplicationByJob(@PathVariable String jobName){
        return applicationService.findApplicationByJob(jobName);
    }

}
