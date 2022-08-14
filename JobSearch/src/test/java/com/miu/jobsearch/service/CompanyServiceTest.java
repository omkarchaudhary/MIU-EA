package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.Client;
import com.miu.jobsearch.entities.Company;
import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.CompanyRepository;
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
public class CompanyServiceTest {
    @Mock
    private CompanyRepository companyRepository;
    @InjectMocks
    private CompanyService companyService;
    private Client client;
    @BeforeEach
    public void createNewCompany_Setup(){
        //company = new Company(LocalDate.now(),1,new Job());
        client = new Client("Google","Social media companu", "social media",
                "https://www.facebook.com/");
        //return company;
    }
    @Test
    public void shouldGetAllCompany_whenRequested_returnAllCompany(){
        //Arrange
        Company clientCompany = client;
        List<Company> repositoryCompanyList = List.of(clientCompany);
        //Act
        when(companyRepository.findAll()).thenReturn(repositoryCompanyList);
        //Assert
        Assertions.assertEquals(companyService.getCompanies(), repositoryCompanyList);
    }
    @Test
    public void shouldGetCompany_whenRequestedById_returnCompany() {

        when(companyRepository.findById(client.getId())).thenReturn(Optional.ofNullable(client));
        Assertions.assertEquals(companyService.getCompany(client.getId()),client);
    }


    @Test
    public void shouldCreateCompany_whenCompanyCreated_returnCompany() {

        when(companyRepository.save(client)).thenReturn(client);
        Assertions.assertEquals(companyService.create(client), client);
    }


    @Test
    public void shouldDeleteCompany_whenCompanyDeleted() {
        Company savedCompany = client;
        //Assert
        companyService.delete(savedCompany.getId());
        verify(companyRepository, atLeast(1)).deleteById(savedCompany.getId());
    }
}
