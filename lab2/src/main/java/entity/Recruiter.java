package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("Recruiter")
public class Recruiter extends  Company{

    @OneToMany(mappedBy ="recruiter")
    List<RecruiterClient> clients;
    public List<RecruiterClient> getClients() {
        return clients;
    }

    public void setClients(List<RecruiterClient> clients) {
        this.clients = clients;
    }
}
