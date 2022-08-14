package com.miu.jobsearch.repository;

import com.miu.jobsearch.entities.Job;
import com.miu.jobsearch.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

//    @Query(value = "select * from Job where id in (select job_id from skill where experience > 2 and language = 'React')",nativeQuery = true)
//    List<Job> findByExperienceAndLanguage(int experience, String language);

    @Query(value = "select j from Skill s inner join Job j on s.job.id = j.id where s.experience < :experience and s.language like :language ")
    List<Job> findAllJobsByExperienceAndLanguage(@Param("experience") int experience, @Param("language") String language);
}
