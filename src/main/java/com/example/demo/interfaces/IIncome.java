package com.example.demo.interfaces;

import com.example.demo.generic.IGenericInterface;
import com.example.demo.models.IncomeModel;

import java.util.List;

public interface IIncome extends IGenericInterface<IncomeModel> {

    List<IncomeModel> getTopThreeByDate();
    float getMonthlyIncome();
}
