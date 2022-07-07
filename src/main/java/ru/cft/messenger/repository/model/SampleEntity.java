package ru.cft.messenger.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "sample")
public class SampleEntity {

    @Id
    @GeneratedValue
    public long id;

    @Column(name = "login", nullable = false) //user email address
    public String login;

    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "surname", nullable = false)
    public String surname;
}
