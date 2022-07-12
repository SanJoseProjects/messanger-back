package ru.cft.messenger.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", nullable = false) //user email address
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 255)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public long getId() { return id; }
    public String getLogin() { return login; }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public Role getRole() { return role; }
    public Status getStatus() { return status; }

    public void setId(long id) { this.id = id; }
    public void setLogin(String login) { this.login = login; }
    public void setPassword(String password) { this.password = password; }
    public void setName(String FCs) { this.name = FCs; }
    public void setRole(Role role) { this.role = role; }
    public void setStatus(Status status) { this.status = status; }
}
