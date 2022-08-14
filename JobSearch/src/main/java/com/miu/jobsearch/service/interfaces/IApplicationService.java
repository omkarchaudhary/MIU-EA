package com.miu.jobsearch.service.interfaces;

import com.miu.jobsearch.entities.Application;

import java.util.List;

public interface IApplicationService {
    List<Application> getAllApplication();
    Application getApplication(int applicationId);
    Application create(Application application);
    void delete(int applicationId);
    List<Application> findApplicationByJob(String jobName);
}
