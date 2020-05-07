package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "account_type")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id",nullable = false)
    @NotNull
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",insertable = false, updatable = false)
    public User user;

    @Column(name = "name",nullable = false)
    @NotNull
    private String name;

    public AccountType(){}

    public AccountType(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
