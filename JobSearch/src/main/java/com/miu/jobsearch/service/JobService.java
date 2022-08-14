package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.Company;
import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.CompanyRepository;
import com.miu.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CompanyRepository companyRepository;
    public List<Job> getJobs(){
        return jobRepository.findAll();
    }

    public Job getJob(Integer id) {
        if (jobRepository.findById(id).isPresent()) {
            return jobRepository.findById(id).get();
        } else {
            new ResourceNotFoundException("No Job register for given Id "+id);
        }
        return null;
    }
    public Job create(Job job) {
        Integer companyId = job.getCompany().getId();
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Job with Id " + companyId +" Not found"));
        job.setCompany(company);
        return jobRepository.save(job);
    }

    public Job update(Job job){
        Job returnJob = jobRepository.findById(job.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Fail to update job ->"+job.getId()));
        return jobRepository.save(returnJob);
    }

    public void delete(Integer id) {
        try {
            jobRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            new ResourceNotFoundException("Job not found for Id:" + id);
        }
    }

    public List<Job> getJobByCompanyName(String companyName){
        return jobRepository.findJobsByCompany_Name(companyName);
    }
    public List<Job> findTopBySalaryGreaterThan(double salary){
        return  jobRepository.findTopBySalaryGreaterThan(salary);
    }

    public List<Job> findJobsByTitle(String title){
        return jobRepository.findJobsByTitle(title);
    }
}
