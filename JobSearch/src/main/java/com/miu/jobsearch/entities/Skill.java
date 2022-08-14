package com.miu.jobsearch.entities;

import javax.persistence.*;

@Entity
public class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;
    private String name;
    private int experience;
    private String description;
    private String language;
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private Job job;

    public Skill() {
    }

    public Skill(String name, int experience, String description, String language, Job job) {
        this.name = name;
        this.experience = experience;
        this.description = description;
        this.language = language;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", job=" + job +
                '}';
    }
}
