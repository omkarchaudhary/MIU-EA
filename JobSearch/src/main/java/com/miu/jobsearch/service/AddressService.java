package com.miu.jobsearch.service;

import com.miu.jobsearch.entities.Address;
import com.miu.jobsearch.entities.Application;
import com.miu.jobsearch.entities.Company;
import com.miu.jobsearch.entities.Interview;
import com.miu.jobsearch.exception.ResourceNotFoundException;
import com.miu.jobsearch.repository.AddressRepository;
import com.miu.jobsearch.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CompanyRepository companyRepository;
    public Address create(Address address) {
        Integer companyId = address.getCompany().getId();
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()->new ResourceNotFoundException("Fail to save Address ->"+companyId));
        address.setCompany(company);
        return addressRepository.save(address);
    }
}
