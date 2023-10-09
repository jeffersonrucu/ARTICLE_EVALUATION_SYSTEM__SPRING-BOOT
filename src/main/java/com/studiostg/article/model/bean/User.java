package com.studiostg.article.model.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Integer permission;

    @NotNull
    private Boolean inactive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private Person person;

    public User() {}

    public User(String username, String password, Integer permission, Boolean inactive, Person person) {
        this.username = username;
        this.password = password;
        this.permission = permission;
        this.inactive = inactive;
        this.person = person;
    }

    public User(Long id, String username, String password, Integer permission, Boolean inactive, Person person) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
        this.inactive = inactive;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public Boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
