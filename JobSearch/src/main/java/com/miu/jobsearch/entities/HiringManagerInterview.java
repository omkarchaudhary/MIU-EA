package com.miu.jobsearch.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "HiringManagerInterview")
public class HiringManagerInterview extends  Interview{
    private int teamSize;
    private LocalDate startDate;

    public HiringManagerInterview() {
    }

    public HiringManagerInterview(LocalDate interviewDate, String phoneNumber, String email, Application application, int teamSize, LocalDate startDate) {
        super(interviewDate, phoneNumber, email, application);
        this.teamSize = teamSize;
        this.startDate = startDate;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
