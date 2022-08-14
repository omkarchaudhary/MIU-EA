package com.miu.jobsearch.repository;

import com.miu.jobsearch.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    public List<Job> findJobsByCompany_Name(String companyName);

    public List<Job> findTopBySalaryGreaterThan(double salary);

    public List<Job> findJobsByTitle(String title);

//    @Query(value = "select * from Job", nativeQuery = true)
//    public List<Job> findAllJobs();

//    @Query("select j from Job j")
//    List<Job> findByJobCCCCCCCCCCCCCCCCCC(String title);

//    @Query(value = "select * from Job where id in (select job_id from skill where experience > 2 and language = 'React')", nativeQuery = true)
//    List<Job> getExperienceAndLanguage();

}
