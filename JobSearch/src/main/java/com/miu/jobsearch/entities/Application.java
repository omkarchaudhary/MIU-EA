package com.miu.jobsearch.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer version;
    private LocalDate applicationDate;
    private int resumeVersion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private Job job;

    public Application() {
    }

    public Application(LocalDate applicationDate, int resumeVersion, Job job) {
        this.applicationDate = applicationDate;
        this.resumeVersion = resumeVersion;
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public int getResumeVersion() {
        return resumeVersion;
    }

    public void setResumeVersion(int resumeVersion) {
        this.resumeVersion = resumeVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return resumeVersion == that.resumeVersion && Objects.equals(id, that.id) && Objects.equals(applicationDate, that.applicationDate) && Objects.equals(job, that.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applicationDate, resumeVersion, job);
    }
}
