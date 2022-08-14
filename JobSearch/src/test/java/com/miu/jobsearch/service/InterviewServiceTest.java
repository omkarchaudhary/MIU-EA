package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.Application;
import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.entities.ScreeningInterview;
import com.miu.jobsearch.entities.Interview;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.ApplicationRepository;
import com.miu.jobsearch.repository.InterviewRepository;
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
public class InterviewServiceTest {
    @Mock
    private InterviewRepository interviewRepository;
    @Mock
    private ApplicationRepository applicationRepository;
    @InjectMocks
    private InterviewService interviewService;
    private ScreeningInterview interview;
    @BeforeEach
    public void createNewInterview_Setup(){
        //interview = new Interview(LocalDate.now(),1,new Job());
        interview = new ScreeningInterview(LocalDate.now(),"98765432","John@miu.com",new Application(),"John","Pass");
        //return interview;
    }
    @Test
    public void shouldGetAllInterview_whenRequested_returnAllInterview(){
        //Arrange
        Interview interviewInterview = interview;
        List<Interview> repositoryInterviewList = List.of(interviewInterview);
        //Act
        when(interviewRepository.findAll()).thenReturn(repositoryInterviewList);
        //Assert
        Assertions.assertEquals(interviewService.getInterviews(), repositoryInterviewList);
    }
    @Test
    public void shouldGetInterview_whenRequestedById_returnInterview() {

        when(interviewRepository.findById(interview.getId())).thenReturn(Optional.ofNullable(interview));
        Assertions.assertEquals(interviewService.getInterview(interview.getId()),interview);
    }

    @Test
    public void shouldCreateInterview_whenInterviewCreated_returnInterview() {
        when(applicationRepository.findById(interview.getApplication().getId())).thenReturn(Optional.ofNullable(new Application()));
        when(interviewRepository.save(interview)).thenReturn(interview);
        Assertions.assertEquals(interviewService.create(interview), interview);
    }


    @Test
    public void shouldDeleteInterview_whenInterviewDeleted() {
        Interview savedInterview = interview;
        //Assert
        interviewService.delete(savedInterview.getId());
        verify(interviewRepository, atLeast(1)).deleteById(savedInterview.getId());
    }
}
