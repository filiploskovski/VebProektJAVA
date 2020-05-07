package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ExpenseModel {

    @JsonProperty("Id")
    private int id;
    @JsonProperty("AccountId")
    private int accountId;
    @JsonProperty("AccountValue")
    private String accountValue;
    @JsonProperty("ExpenseTypeId")
    private int expenseTypeId;
    @JsonProperty("ExpenseTypeValue")
    private String expenseTypeValue;
    @JsonProperty("Amount")
    private float amount;
    @JsonProperty("Date")
    private Date date;



    @JsonProperty("Name")
    private String name;

    public ExpenseModel(){}

    public ExpenseModel(@JsonProperty("AccountId") int accountId, @JsonProperty("ExpenseTypeId") int expenseTypeId, @JsonProperty("Amount") float amount, @JsonProperty("Date") Date date,@JsonProperty("Name") String name) {
        this.accountId = accountId;
        this.expenseTypeId = expenseTypeId;
        this.amount = amount;
        this.date = date;
        this.name = name;
    }

    public ExpenseModel(int id, int accountId, String accountValue, int expenseTypeId, String expenseTypeValue, float amount, Date date, String name) {
        this.id = id;
        this.accountId = accountId;
        this.accountValue = accountValue;
        this.expenseTypeId = expenseTypeId;
        this.expenseTypeValue = expenseTypeValue;
        this.amount = amount;
        this.date = date;
        this.name = name;
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

    public String getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(String accountValue) {
        this.accountValue = accountValue;
    }

    public int getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(int expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public String getExpenseTypeValue() {
        return expenseTypeValue;
    }

    public void setExpenseTypeValue(String expenseTypeValue) {
        this.expenseTypeValue = expenseTypeValue;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
