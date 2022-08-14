package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.Application;
import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.ApplicationRepository;
import com.miu.jobsearch.repository.JobRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {
    @Mock
    private ApplicationRepository applicationRepository;
    @Mock
    private JobRepository jobRepository;
    @InjectMocks
    private ApplicationService applicationService;
    private Application application;
    @BeforeEach
    public void createNewApplication_Setup(){
        application = new Application(LocalDate.now(),1,new Job());
        //return application;
    }
    @Test
    public void shouldGetAllApplication_whenRequested_returnAllApplication(){
        //Arrange
        Application developerApplication = application;
        List<Application> repositoryApplicationList = List.of(developerApplication);
        //Act
        when(applicationRepository.findAll()).thenReturn(repositoryApplicationList);
        //Assert
        Assertions.assertEquals(applicationService.getAllApplication(), repositoryApplicationList);
    }
    @Test
    public void shouldGetApplication_whenRequestedById_returnApplication() {

        when(applicationRepository.findById(application.getId())).thenReturn(Optional.ofNullable(application));
        Assertions.assertEquals(applicationService.getApplication(application.getId()),application);
    }

    @Test
    public void shouldCreateApplication_whenApplicationCreated_returnApplication() {
        when(jobRepository.findById(application.getJob().getId())).thenReturn(Optional.ofNullable(new Job()));
        when(applicationRepository.save(application)).thenReturn(application);
        Assertions.assertEquals(applicationService.create(application), application);
    }

    @Test
    public void shouldDeleteApplication_whenApplicationDeleted() {
        Application savedApplication = application;
        //Assert
        applicationService.delete(savedApplication.getId());
        verify(applicationRepository, atLeast(1)).deleteById(savedApplication.getId());
    }
}
