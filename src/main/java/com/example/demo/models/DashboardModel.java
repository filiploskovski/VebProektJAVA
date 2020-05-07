package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DashboardModel {
    @JsonProperty("Income")
    private List<IncomeModel> income;
    @JsonProperty("Expense")
    private List<ExpenseModel> expense;
    @JsonProperty("Accounts")
    private List<AccountModel> accounts;
    @JsonProperty("MonthlyIncome")
    private float monthlyIncome;
    @JsonProperty("DailyExpenses")
    private float dailyExpenses;

    public DashboardModel(List<IncomeModel> income, List<ExpenseModel> expense, List<AccountModel> accounts, float monthlyIncome, float dailyExpenses) {
        this.income = income;
        this.expense = expense;
        this.accounts = accounts;
        this.monthlyIncome = monthlyIncome;
        this.dailyExpenses = dailyExpenses;
    }
}
