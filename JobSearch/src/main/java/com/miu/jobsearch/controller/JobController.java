package com.miu.jobsearch.controller;

import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;
    @GetMapping(path = "/job")
    public List<Job> getJobs(){
        return jobService.getJobs();
    }

    @GetMapping(path = "/job/{id}")
    public Job getJob(@PathVariable int id){
        return jobService.getJob(id);
    }

    @DeleteMapping("/job/{id}")
    public void deleteJob(@PathVariable int id){
        jobService.delete(id);
    }

    @PostMapping(path = "/job")
    public ResponseEntity<?> createInterview(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.create(job), HttpStatus.OK);
    }

    @PutMapping(path = "/job")
    public ResponseEntity<?> updateInterview(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.update(job), HttpStatus.OK);
    }

    @GetMapping(path = "/jobByCompany/{companyName}")
    public List<Job> getJobByCompanyName(@PathVariable String companyName){
        return jobService.getJobByCompanyName(companyName);
    }

    @GetMapping(path = "/jobBySalary/{salary}")
    public List<Job> findTopBySalaryGreaterThan(@PathVariable double salary){
        return jobService.findTopBySalaryGreaterThan(salary);
    }
    @GetMapping(path = "jobByTitle/{title}")
    public List<Job> findJobsByTitle(@PathVariable String title){
        return jobService.findJobsByTitle(title);
    }
}
