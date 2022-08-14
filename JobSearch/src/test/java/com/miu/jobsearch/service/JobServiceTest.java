package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.*;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.CompanyRepository;
import com.miu.jobsearch.repository.JobRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;
@ExtendWith(MockitoExtension.class)
public class JobServiceTest {
    @Mock
    private JobRepository jobRepository;
    @Mock
    private CompanyRepository companyRepository;
    @InjectMocks
    private JobService jobService;
    private Job job;
    @BeforeEach
    public void createNewJob_Setup(){
        //job = new Job(LocalDate.now(),1,new Job());
        job = new Job("Software Developer",90000,new Client());
        //return job;
    }
    @Test
    public void shouldGetAllJob_whenRequested_returnAllJob(){
        //Arrange
        Job jobJob = job;
        List<Job> repositoryJobList = List.of(jobJob);
        //Act
        when(jobRepository.findAll()).thenReturn(repositoryJobList);
        //Assert
        Assertions.assertEquals(jobService.getJobs(), repositoryJobList);
    }
    @Test
    public void shouldGetJob_whenRequestedById_returnJob() {
        when(jobRepository.findById(job.getId())).thenReturn(Optional.ofNullable(job));
        Assertions.assertEquals(jobService.getJob(job.getId()),job);
    }

    @Test
    public void shouldCreateJob_whenJobCreated_returnJob() {
        when(companyRepository.findById(job.getCompany().getId())).thenReturn(Optional.ofNullable(new Recruiter()));
        when(jobRepository.save(job)).thenReturn(job);
        Assertions.assertEquals(jobService.create(job), job);
    }


    @Test
    public void shouldDeleteJob_whenJobDeleted() {
        Job savedJob = job;
        //Assert
        jobService.delete(savedJob.getId());
        verify(jobRepository, atLeast(1)).deleteById(savedJob.getId());
    }
}
