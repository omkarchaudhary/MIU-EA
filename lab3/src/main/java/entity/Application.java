package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate applicationDate;
    private String resumeVersion;
   @OneToOne
   @JoinColumn(name = "job_id")
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getResumeVersion() {
        return resumeVersion;
    }

    public void setResumeVersion(String resumeVersion) {
        this.resumeVersion = resumeVersion;
    }
}
