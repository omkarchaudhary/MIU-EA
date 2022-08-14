package com.miu.jobsearch.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "Client")
public class Client extends Company implements Serializable {
    private String mission;
    private String reason;
    private String website;

    public Client() {
    }

    public Client(String name, String mission, String reason, String website) {
        super(name);
        this.mission = mission;
        this.reason = reason;
        this.website = website;
    }

    public String getMission() {
        return mission;
    }
    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Client{" +
                "mission='" + mission + '\'' +
                ", reason='" + reason + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
