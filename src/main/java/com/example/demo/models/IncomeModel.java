package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class IncomeModel {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("AccountId")
    private int accountId;
    @JsonProperty("AccountValue")
    private String accountValue;
    @JsonProperty("IncomeTypeId")
    private int incomeTypeId;
    @JsonProperty("IncomeTypeValue")
    private String incomeTypeValue;
    @JsonProperty("Amount")
    private float amount;
    @JsonProperty("Date")
    private Date date;
    @JsonProperty("IsMonthly")
    private Boolean isMonthly;
    @JsonProperty("Name")
    private String name;

    public IncomeModel(){}

    public IncomeModel(int id, int accountId, String accountValue, int incomeTypeId, String incomeTypeValue, float amount, Date date, Boolean isMonthly,String name) {
        this.id = id;
        this.accountId = accountId;
        this.accountValue = accountValue;
        this.incomeTypeId = incomeTypeId;
        this.incomeTypeValue = incomeTypeValue;
        this.amount = amount;
        this.date = date;
        this.isMonthly = isMonthly;
        this.name = name;
    }

    public IncomeModel(@JsonProperty("AccountId") int accountId,
                       @JsonProperty("IncomeTypeId")int incomeTypeId,
                       @JsonProperty("Amount")float amount,
                       @JsonProperty("Date")Date date,
                       @JsonProperty("IsMonthly")Boolean isMonthly,
                       @JsonProperty("Name")String name) {
        this.accountId = accountId;
        this.incomeTypeId = incomeTypeId;
        this.amount = amount;
        this.date = date;
        this.isMonthly = isMonthly;
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

    public int getIncomeTypeId() {
        return incomeTypeId;
    }

    public void setIncomeTypeId(int incomeTypeId) {
        this.incomeTypeId = incomeTypeId;
    }

    public String getIncomeTypeValue() {
        return incomeTypeValue;
    }

    public void setIncomeTypeValue(String incomeTypeValue) {
        this.incomeTypeValue = incomeTypeValue;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
