package com.miu.jobsearch.controller;

import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.entities.Skill;
import com.miu.jobsearch.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SkillController {
    @Autowired
    private SkillService skillService;
    @GetMapping(path = "/skill")
    public List<Skill> getSkills(){
        return skillService.getSkills();
    }

    @GetMapping(path = "/skill/{id}")
    public Skill getSkill(@PathVariable int id){
        return skillService.getSkill(id);
    }

    @PostMapping(path = "/skill")
    public ResponseEntity<?> createInterview(@RequestBody Skill skill) {
        return new ResponseEntity<>(skillService.create(skill), HttpStatus.OK);
    }

    @PutMapping(path = "/skill")
    public ResponseEntity<?> updateInterview(@RequestBody Skill skill) {
        return new ResponseEntity<>(skillService.update(skill), HttpStatus.OK);
    }

    @DeleteMapping("/skill/{id}")
    public void deleteSkill(@PathVariable int id){
        skillService.delete(id);
    }

    @GetMapping(path = "/skill/{exp}/{language}")
    public List<Job> findByExperienceAndLanguage(@PathVariable int exp, @PathVariable String language){
        return skillService.findByExperienceAndLanguage(exp,language);
    }
}
