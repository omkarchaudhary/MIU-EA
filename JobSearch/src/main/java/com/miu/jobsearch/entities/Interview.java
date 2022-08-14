package com.miu.jobsearch.entities;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Interview_Type")
public abstract class Interview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer version;
    private LocalDate interviewDate;

    private String phoneNumber;
    private String email;
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "application_id")
    private Application application;

    public Interview() {
    }

    public Interview(LocalDate interviewDate, String phoneNumber, String email, Application application) {
        this.interviewDate = interviewDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.application = application;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", interviewDate=" + interviewDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
