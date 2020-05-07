package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "income")
public class Income {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_id",nullable = false)
    private int accountId;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Account account;

    @Column(name = "income_type_id",nullable = false)
    @NotNull
    private int incomeTypeId;

    @ManyToOne
    @JoinColumn(name = "income_type_id",referencedColumnName = "id",insertable = false, updatable = false)
    private IncomeType incomeType;

    @Column(name = "name",nullable = false)
    @NotNull
    private String name;

    @Column(name = "amount",nullable = false)
    @NotNull
    private float amount;

    @Column(name = "date",nullable = false)
    @NotNull
    private Date date;

    @Column(name = "is_monthly",nullable = false)
    @NotNull
    private Boolean isMonthly;

    public Income(){}

    public Income(int accountId, int incomeTypeId, String name, float amount, Date date, Boolean isMonthly) {
        this.accountId = accountId;
        this.incomeTypeId = incomeTypeId;
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.isMonthly = isMonthly;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getIncomeTypeId() {
        return incomeTypeId;
    }

    public void setIncomeTypeId(int incomeTypeId) {
        this.incomeTypeId = incomeTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getMonthly() {
        return isMonthly;
    }

    public void setMonthly(Boolean monthly) {
        isMonthly = monthly;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }
}
