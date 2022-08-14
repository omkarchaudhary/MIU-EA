package com.test.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name = "Movie.findPersonsByMovieName",query = "select m.person from Movie m where m.title = :title")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int year;
    @OneToMany
    private List<Person> person;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
