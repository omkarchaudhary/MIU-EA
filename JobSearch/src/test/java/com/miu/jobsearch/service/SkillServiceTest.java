package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.entities.Recruiter;
import com.miu.jobsearch.entities.Skill;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.JobRepository;
import com.miu.jobsearch.repository.SkillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;

@ExtendWith(MockitoExtension.class)
public class SkillServiceTest {
    @Mock
    private SkillRepository skillRepository;
    @Mock
    private JobRepository jobRepository;
    @InjectMocks
    private SkillService skillService;
    private Skill skill;
    @BeforeEach
    public void createNewSkill_Setup(){
        //skill = new Skill(LocalDate.now(),1,new Skill());
        skill = new Skill("frontend", 2, "Design and implementation of UI",
                "Angular",new Job());
        //return skill;
    }
    @Test
    public void shouldGetAllSkill_whenRequested_returnAllSkill(){
        //Arrange
        Skill skillSkill = skill;
        List<Skill> repositorySkillList = List.of(skillSkill);
        //Act
        when(skillRepository.findAll()).thenReturn(repositorySkillList);
        //Assert
        Assertions.assertEquals(skillService.getSkills(), repositorySkillList);
    }
    @Test
    public void shouldGetSkill_whenRequestedById_returnSkill() {

        when(skillRepository.findById(skill.getId())).thenReturn(Optional.ofNullable(skill));
        Assertions.assertEquals(skillService.getSkill(skill.getId()),skill);
    }


    @Test
    public void shouldCreateSkill_whenSkillCreated_returnSkill() {
        when(jobRepository.findById(skill.getJob().getId())).thenReturn(Optional.ofNullable(new Job()));
        when(skillRepository.save(skill)).thenReturn(skill);
        Assertions.assertEquals(skillService.create(skill), skill);
    }


    @Test
    public void shouldDeleteSkill_whenSkillDeleted() {
        Skill savedSkill = skill;
        //Assert
        skillService.delete(savedSkill.getId());
        verify(skillRepository, atLeast(1)).deleteById(savedSkill.getId());
    }
}
