package ru.kpfu.itis.genatulin.hw3.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    public static final String ID_COLUMN_NAME = "id";
    public static final String EMAIL_COLUMN_NAME = "email";
    public static final String USERNAME_COLUMN_NAME = "username";
    public static final String PASSWORD_COLUMN_NAME = "password";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_COLUMN_NAME, nullable = false)
    private Long id;

    @Column(name = EMAIL_COLUMN_NAME, nullable = false, unique = true)
    private String email;

    @Column(name = USERNAME_COLUMN_NAME, nullable = false, unique = true)
    private String username;

    @Column(name = PASSWORD_COLUMN_NAME, nullable = false, unique = true)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}