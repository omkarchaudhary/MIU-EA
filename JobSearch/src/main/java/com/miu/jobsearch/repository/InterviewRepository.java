package com.miu.jobsearch.repository;

import com.miu.jobsearch.entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {
    public Interview findInterviewByApplication_Job_Title(String title);
}
