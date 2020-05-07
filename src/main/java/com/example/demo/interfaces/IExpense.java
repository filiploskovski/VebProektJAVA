package com.example.demo.interfaces;

import com.example.demo.generic.IGenericInterface;
import com.example.demo.models.ExpenseModel;

import java.util.List;

public interface IExpense extends IGenericInterface<ExpenseModel> {

    List<ExpenseModel> getDailyExpense();
    float getDailyExpenseSum();
}
