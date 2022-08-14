package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name="Job.findJobByState",query = "SELECT j FROM Job j where j.company.address = :state")
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double salary;

    @OneToMany(mappedBy = "job")
    private List<Skill> skills;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                ", company=" + company +
                '}';
    }
}
