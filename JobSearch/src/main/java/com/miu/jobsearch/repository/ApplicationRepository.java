package com.miu.jobsearch.repository;

import com.miu.jobsearch.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    public List<Application> findApplicationByJob_Title(String jobName);
}
