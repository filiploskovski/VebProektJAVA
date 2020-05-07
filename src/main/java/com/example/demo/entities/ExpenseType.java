package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "expense_type")
public class ExpenseType {

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

    @OneToMany(targetEntity=Expense.class, mappedBy="expenseType",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Expense> expenses = new ArrayList<>();

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

    public ExpenseType(String name) {
        this.name = name;
    }

    public ExpenseType(){}


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
