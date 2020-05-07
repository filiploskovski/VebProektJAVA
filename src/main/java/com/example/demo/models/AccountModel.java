package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AccountModel {
    @JsonProperty("Id")
    private int id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("AccountTypeId")
    private int accountTypeId;

    @JsonProperty("AccountTypeValue")
    private String accountTypeValue;

    @JsonProperty("Amount")
    private float amount;

    @JsonProperty("IsDefault")
    private boolean isDefault;

    @JsonProperty("Income")
    private List<IncomeModel> income;

    @JsonProperty("Expense")
    private List<ExpenseModel> expense;

    public AccountModel(int id, int accountTypeId, String accountTypeValue, float amount, boolean isDefault,String name, List<IncomeModel> income,List<ExpenseModel> expense) {
        this.id = id;
        this.accountTypeId = accountTypeId;
        this.accountTypeValue = accountTypeValue;
        this.amount = amount;
        this.isDefault = isDefault;
        this.income = income;
        this.name = name;
        this.expense = expense;
    }

    public AccountModel(int id, int accountTypeId, String accountTypeValue, float amount, boolean isDefault,String name) {
        this.id = id;
        this.accountTypeId = accountTypeId;
        this.accountTypeValue = accountTypeValue;
        this.amount = amount;
        this.isDefault = isDefault;
        this.name = name;
    }

    public AccountModel(@JsonProperty("Name") String name, @JsonProperty("AccountTypeId")int accountTypeId, @JsonProperty("Amount")float amount, @JsonProperty("IsDefault")boolean isDefault) {
        this.name = name;
        this.accountTypeId = accountTypeId;
        this.amount = amount;
        this.isDefault = isDefault;
    }

    public List<IncomeModel> getIncome() {
        return income;
    }

    public void setIncome(List<IncomeModel> income) {
        this.income = income;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeValue() {
        return accountTypeValue;
    }

    public void setAccountTypeValue(String accountTypeValue) {
        this.accountTypeValue = accountTypeValue;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExpenseModel> getExpense() {
        return expense;
    }

    public void setExpense(List<ExpenseModel> expense) {
        this.expense = expense;
    }
}
