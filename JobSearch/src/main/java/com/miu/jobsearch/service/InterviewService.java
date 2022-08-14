package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.Application;
import com.miu.jobsearch.entities.Interview;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.ApplicationRepository;
import com.miu.jobsearch.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Interview> getInterviews(){
        return interviewRepository.findAll();
    }

    public Interview getInterview(Integer id) {
        if (interviewRepository.findById(id).isPresent()) {
            return interviewRepository.findById(id).get();
        } else {
            new ResourceNotFoundException("No Interview register for given Id "+id);
        }
        return null;
    }
    public Interview create(Interview interview) {
        Integer applicationId = interview.getApplication().getId();
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(()->new ResourceNotFoundException("Fail to save interview ->"+applicationId));
        interview.setApplication(application);
        return interviewRepository.save(interview);
    }

    public Interview update(Interview interview){
        Interview returnInterview = interviewRepository.findById(interview.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Fail to update interview ->"+interview.getId()));
        return interviewRepository.save(returnInterview);
    }

    public void delete(Integer id) {
        try {
            interviewRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            new ResourceNotFoundException("Interview not found for Id:" + id);
        }
    }

    public Interview findInterviewByApplicationJob(String title){
        return interviewRepository.findInterviewByApplication_Job_Title(title);
    }
}
