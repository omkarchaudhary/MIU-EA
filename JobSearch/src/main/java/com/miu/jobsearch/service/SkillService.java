package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.entities.Skill;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.JobRepository;
import com.miu.jobsearch.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobRepository jobRepository;
    
    public List<Skill> getSkills(){
        return skillRepository.findAll();
    }

    public Skill getSkill(Integer id) {
        if (skillRepository.findById(id).isPresent()) {
            return skillRepository.findById(id).get();
        } else {
            new ResourceNotFoundException("No Skill register for given Id "+id);
        }
        return null;
    }
    public Skill create(Skill skill) {
        Integer jobId = skill.getJob().getId();
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job with Id " + jobId +" Not found"));
        skill.setJob(job);
        return skillRepository.save(skill);
    }

    public Skill update(Skill skill){
        Skill returnSkill = skillRepository.findById(skill.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Fail to update skill ->"+skill.getId()));
        return skillRepository.save(returnSkill);
    }

    public void delete(Integer id) {
        try {
            skillRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            new ResourceNotFoundException("Skill not found for Id:" + id);
        }
    }

    public List<Job> findByExperienceAndLanguage(int exp, String lang){
        return skillRepository.findAllJobsByExperienceAndLanguage(exp, lang);
    }
}
