package ru.cft.messenger.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "login", nullable = false) //user email address
    public String login;

    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "surname", nullable = false)
    public String surname;

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
