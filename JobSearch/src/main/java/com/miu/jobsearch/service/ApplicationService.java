package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.Application;
import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.ApplicationRepository;
import com.miu.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }

    public Application getApplication(Integer applicationId) {
        Optional<Application> applicationOptional = applicationRepository.findById(applicationId);
        if (applicationOptional.isPresent()) {
            return applicationOptional.get();
        } else {
            new ResourceNotFoundException("Application not found for Id:" + applicationId);
        }
        return null;
    }

    public Application create(Application application) {
        Integer jobId = application.getJob().getId();
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job with Id " + jobId +" Not found"));
        application.setJob(job);
        return applicationRepository.save(application);
    }

    public Application update(Application application) {
        Application returnApplication = applicationRepository.findById(application.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Fail to update application ->" + application.getId()));
        return applicationRepository.save(returnApplication);
    }

    public void delete(Integer applicationId) {
        try {
            applicationRepository.deleteById(applicationId);
        } catch (EmptyResultDataAccessException e) {
            new ResourceNotFoundException("Application not found for Id:" + applicationId);
        }
    }

    public List<Application> findApplicationByJob(String jobName) {
        return applicationRepository.findApplicationByJob_Title(jobName);
    }
}
