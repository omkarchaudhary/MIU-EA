package com.miu.jobsearch.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "ScreeningInterview")
public class ScreeningInterview extends Interview{
    private  String name;
    private String result;

    public ScreeningInterview() {
    }

    public ScreeningInterview(LocalDate interviewDate, String phoneNumber, String email, Application application, String name, String result) {
        super(interviewDate, phoneNumber, email, application);
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
