package com.studiostg.article.model.bean;

import jakarta.persistence.*;

@Entity(name = "Evaluator")
@Table(name = "evaluator")
public class Evaluator {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private Person person;

    public Evaluator() {}

    public Evaluator(Person person) {
        this.person = person;
    }

    public Evaluator(Long id, Person person) {
        this.id = id;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
