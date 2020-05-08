package com.example.demo.services;

import com.example.demo.JWT.ClaimsService;
import com.example.demo.entities.Account;
import com.example.demo.entities.Expense;
import com.example.demo.interfaces.IExpense;
import com.example.demo.models.ExpenseModel;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.repository.IExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService implements IExpense {

    private final IExpenseRepository _expenseRepository;
    private final IAccountRepository _accountRepository;
    private final ClaimsService claimsService;


    @Autowired
    public ExpenseService(IExpenseRepository _expenseRepository, IAccountRepository accountRepository, ClaimsService claimsService) {
        this._expenseRepository = _expenseRepository;
        _accountRepository = accountRepository;
        this.claimsService = claimsService;
    }

    @Override
    public List<ExpenseModel> get() {
        return _expenseRepository.findAll().stream().map(x ->
                new ExpenseModel(x.getId(),x.getAccountId(),x.getAccount().getName(),x.getExpenseTypeId(),x.getExpenseType().getName(),x.getAmount(),x.getDate(),x.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ExpenseModel> getByUserId() {
        return null;
    }

    @Override
    public ExpenseModel getById(int id) {
        Expense x = _expenseRepository.findFirstById(id);
        return new ExpenseModel(x.getId(),x.getAccountId(),x.getAccount().getName(),x.getExpenseTypeId(),x.getExpenseType().getName(),x.getAmount(),x.getDate(),x.getName());

    }

    @Override
    public void insert(ExpenseModel model) {
        Expense x = new Expense(model.getAccountId(),model.getExpenseTypeId(),model.getAmount(),model.getName(),model.getDate());
        _expenseRepository.save(x);
        ExpenseToAccount(model,model.getAccountId());
    }

    @Override
    public void update(ExpenseModel model) {
        Expense x = _expenseRepository.findFirstById(model.getId());
        ExpenseToAccount(model,model.getAccountId());

        x.setAccountId(model.getAccountId());
        x.setExpenseTypeId(model.getExpenseTypeId());
        x.setName(model.getName());
        x.setAmount(model.getAmount());
        x.setDate(model.getDate());

        _expenseRepository.save(x);
    }

    @Override
    public void delete(int id) {
        Expense expense = _expenseRepository.findFirstById(id);
        Account account = _accountRepository.findFirstById(expense.getAccountId());
        account.setAmount(account.getAmount() + expense.getAmount());
        _accountRepository.save(account);
        _expenseRepository.delete(expense);
    }


    private void ExpenseToAccount(ExpenseModel model,int accountId){
        Account account = _accountRepository.findFirstById(accountId);

        if(model.getId() == 0){
            account.setAmount(account.getAmount() - model.getAmount());
        }else{
            Expense expense = _expenseRepository.findFirstById(model.getId());

            if(expense.getAmount() != model.getAmount()){
                float diff = 0;
                if(model.getAmount() > expense.getAmount()){
                    diff = model.getAmount() - expense.getAmount();
                    account.setAmount(account.getAmount() - diff);
                }else{
                    diff = expense.getAmount() - model.getAmount();
                    account.setAmount(account.getAmount() + diff);
                }
            }
        }
        _accountRepository.save(account);
    }

    @Override
    public List<ExpenseModel> getDailyExpense() {
        List<Integer> accountIds = _accountRepository.findAllByUserId(claimsService.GetUserIdFromToken()).stream().map(x -> x.getId()).collect(Collectors.toList());

        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return _expenseRepository.findAllByAccountIdInAndDate(accountIds,date).stream().map(x ->
                new ExpenseModel(x.getId(),x.getAccountId(),x.getAccount().getName(),x.getExpenseTypeId(),x.getExpenseType().getName(),x.getAmount(),x.getDate(),x.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public float getDailyExpenseSum() {
        List<Integer> accountIds = _accountRepository.findAllByUserId(claimsService.GetUserIdFromToken())
                .stream().map(x -> x.getId()).collect(Collectors.toList());

        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return (float)_expenseRepository
                .findAllByAccountIdInAndDate(accountIds,date).stream().mapToDouble(x -> x.getAmount()).sum();
    }
}
