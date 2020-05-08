package com.example.demo.controller;

import com.example.demo.interfaces.IAccount;
import com.example.demo.interfaces.IExpense;
import com.example.demo.interfaces.IIncome;
import com.example.demo.models.AccountModel;
import com.example.demo.models.DashboardModel;
import com.example.demo.models.ExpenseModel;
import com.example.demo.models.IncomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private final IAccount _account;
    private final IIncome _income;
    private final IExpense _expense;

    @Autowired
    public HomeController(IAccount account, IIncome income, IExpense expense) {
        _account = account;
        _income = income;
        _expense = expense;
    }


    @GetMapping
    @RequestMapping("/dashboard")
    public DashboardModel get(){
        List<AccountModel> accounts = _account.getByUserId();
        List<IncomeModel> income = _income.getTopThreeByDate();
        float dailyExpense = _expense.getDailyExpenseSum();
        List<ExpenseModel> expense = _expense.getDailyExpense();
        float monthlyIncome = _income.getMonthlyIncome();
        return new DashboardModel(income,expense,accounts,monthlyIncome,dailyExpense);
    }
}
