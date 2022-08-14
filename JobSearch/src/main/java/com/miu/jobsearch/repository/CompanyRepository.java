package com.miu.jobsearch.repository;

import com.miu.jobsearch.entities.Company;
import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.entities.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query(value = "select c from Company c join Address a on c.id=a.company.id and a.state = ?1")
    List<Company> findCompaniesByAddressInGivenState(String state);
}
