package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.Company;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompany(Integer id) {
        if (companyRepository.findById(id).isPresent()) {
            return companyRepository.findById(id).get();
        } else {
            new ResourceNotFoundException("No company register for given Id "+id);
        }
        return null;
    }
    public Company create(Company company) {
        return companyRepository.save(company);
    }
    public Company update(Company company){
            Company returnCompany = companyRepository.findById(company.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Fail to update company ->"+company.getId()));
            return companyRepository.save(returnCompany);
    }

    public void delete(Integer id) {
        try {
            companyRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            new ResourceNotFoundException("Company not found for Id:" + id);
        }
    }
    public List<Company> findCompaniesByAddressInGivenState(String state){
//        return companyRepository.findCompaniesByAddressInGivenState(state);
        return companyRepository.findAll();
    }
}
