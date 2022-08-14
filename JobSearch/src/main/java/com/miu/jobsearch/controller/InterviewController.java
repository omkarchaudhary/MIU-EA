package com.miu.jobsearch.controller;

import com.miu.jobsearch.entities.*;
import com.miu.jobsearch.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
    @GetMapping(path = "/interview")
    public List<Interview> getInterviews(){
        return interviewService.getInterviews();
    }

    @GetMapping(path = "/interview/{id}")
    public Interview getInterview(@PathVariable int id){
        return interviewService.getInterview(id);
    }

    @PostMapping(path = "/screening")
    public ResponseEntity<?> createScreeningInterview(@RequestBody ScreeningInterview interview) {
        return new ResponseEntity<>(interviewService.create(interview), HttpStatus.OK);
    }
    @PostMapping(path = "/technical")
    public ResponseEntity<?> createTechnicalInterview(@RequestBody TechnicalInterview interview) {
        return new ResponseEntity<>(interviewService.create(interview), HttpStatus.OK);
    }
    @PostMapping(path = "/managerial")
    public ResponseEntity<?> createManagerialInterview(@RequestBody HiringManagerInterview interview) {
        return new ResponseEntity<>(interviewService.create(interview), HttpStatus.OK);
    }

    @PutMapping(path = "/screening")
    public ResponseEntity<?> updateScreeningInterview(@RequestBody Interview interview) {
        return new ResponseEntity<>(interviewService.update(interview), HttpStatus.OK);
    }
    @PutMapping(path = "/technical")
    public ResponseEntity<?> updateTechnicalInterview(@RequestBody Interview interview) {
        return new ResponseEntity<>(interviewService.update(interview), HttpStatus.OK);
    }
    @PutMapping(path = "/managerial")
    public ResponseEntity<?> updateManagerialInterview(@RequestBody Interview interview) {
        return new ResponseEntity<>(interviewService.update(interview), HttpStatus.OK);
    }

    @DeleteMapping("/interview/{id}")
    public void deleteInterview(@PathVariable int id){
        interviewService.delete(id);
    }

    @GetMapping(path = "/interview/job/{title}")
    public Interview getInterviewByJobTitle(@PathVariable String title){
        return interviewService.findInterviewByApplicationJob(title);
    }
}
