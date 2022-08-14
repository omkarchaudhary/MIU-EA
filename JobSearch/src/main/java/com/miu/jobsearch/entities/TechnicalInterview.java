package com.miu.jobsearch.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "TechnicalInterview")
public class TechnicalInterview extends Interview{
    private int duration;
    @Enumerated(EnumType.STRING)
    private Location location;
    private String questions;

    public TechnicalInterview() {
    }

    public TechnicalInterview(LocalDate interviewDate, String phoneNumber, String email, Application application, int duration, Location location, String questions) {
        super(interviewDate, phoneNumber, email, application);
        this.duration = duration;
        this.location = location;
        this.questions = questions;
    }

    public Location getLocation() {
        return location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}
