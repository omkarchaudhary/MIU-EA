package com.miu.jobsearch.entities;

import javax.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue(value = "Recruiter")
public class Recruiter extends  Company{
    @OneToMany
    List<Client> clients;

    public Recruiter() {
    }

    public Recruiter(String name) {
        super(name);
    }

    //    public Recruiter(String name) {
//        this.clients = clients;
//    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
