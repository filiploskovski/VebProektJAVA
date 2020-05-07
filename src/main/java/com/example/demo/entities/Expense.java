package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_id",nullable = false)
    @NotNull
    private int accountId;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Account account;

    @Column(name = "expense_type_id",nullable = false)
    @NotNull
    private int expenseTypeId;

    @ManyToOne
    @JoinColumn(name = "expense_type_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ExpenseType expenseType;

    @Column(name = "amount",nullable = false)
    @NotNull
    private float amount;

    @Column(name = "name",nullable = false)
    @NotNull
    private String name;

    @Column(name = "date",nullable = false)
    @NotNull
    private Date date;

    public Expense(){}

    public Expense(@NotNull int accountId, @NotNull int expenseTypeId, @NotNull float amount, @NotNull String name, @NotNull Date date) {
        this.accountId = accountId;
        this.expenseTypeId = expenseTypeId;
        this.amount = amount;
        this.name = name;
        this.date = date;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(int expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
