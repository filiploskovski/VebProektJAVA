package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id",nullable = false)
    @NotNull
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false,updatable = false)
    private User user;

    @Column(name = "account_type_id",nullable = false)
    @NotNull
    private int accountTypeId;

    @ManyToOne
    @JoinColumn(name = "account_type_id",referencedColumnName = "id",insertable = false,updatable = false)
    private AccountType accountType;

    @Column(name = "amount",nullable = false)
    @NotNull
    private float amount;

    @Column(name = "is_default",nullable = false)
    @NotNull
    private Boolean isDefault;

    @Column(name = "name",nullable = false)
    @NotNull
    private String name;

    @OneToMany(targetEntity=Income.class, mappedBy="account",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Income> income = new ArrayList<>();

    @OneToMany(targetEntity=Expense.class, mappedBy="account",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Expense> expenses = new ArrayList<>();

    public Account(){}

    public Account(int userId, int accountTypeId, float amount, Boolean isDefault, String name) {
        this.userId = userId;
        this.accountTypeId = accountTypeId;
        this.amount = amount;
        this.isDefault = isDefault;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Income> getIncome() {
        return income;
    }

    public void setIncome(List<Income> income) {
        this.income = income;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
