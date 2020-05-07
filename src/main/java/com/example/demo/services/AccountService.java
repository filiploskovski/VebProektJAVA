package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.interfaces.IAccount;
import com.example.demo.models.AccountModel;
import com.example.demo.models.ExpenseModel;
import com.example.demo.models.IncomeModel;
import com.example.demo.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccount {

    private final IAccountRepository _IAccountRepository;

    @Autowired
    public AccountService(IAccountRepository iAccountRepository) {
        _IAccountRepository = iAccountRepository;
    }

    @Override
    public List<AccountModel> get() {
        return _IAccountRepository.findAll().stream().map(x ->
                new AccountModel(x.getId(),
                        x.getAccountTypeId(),
                        x.getAccountType().getName(),
                        x.getAmount(),
                        x.getDefault(),
                        x.getName())).collect(Collectors.toList());
    }

    @Override
    public List<AccountModel> getByUserId(int userId) {
        return _IAccountRepository.findAllByUserId(userId).stream().map(x ->
                new AccountModel(x.getId(),
                        x.getAccountTypeId(),
                        x.getAccountType().getName(),
                        x.getAmount(),
                        x.getDefault(),
                        x.getName())).collect(Collectors.toList());
    }

    @Override
    public AccountModel getById(int id) {
        Account account = _IAccountRepository.findFirstById(id);
        AccountModel model = new AccountModel(account.getId(),
                account.getAccountTypeId(),
                account.getAccountType().getName(),
                account.getAmount(),
                account.getDefault(),
                account.getName(),
                account.getIncome().stream().map(y ->new IncomeModel(y.getId(),y.getAccountId(),y.getAccount().getName(),y.getIncomeTypeId(),
                        y.getIncomeType().getName(),y.getAmount(),y.getDate(),y.getMonthly(),y.getName())).collect(Collectors.toList()),
                        account.getExpenses().stream().map(x -> new ExpenseModel(x.getId(),x.getAccountId(),x.getAccount().getName(),x.getExpenseTypeId(),x.getExpenseType().getName(),x.getAmount(),x.getDate(),x.getName()))
                                .collect(Collectors.toList()));
        return model;
    }

    @Override
    public void insert(AccountModel model) {

        Account entity = new Account();
        entity.setAccountTypeId(model.getAccountTypeId());
        entity.setDefault(model.isDefault());
        entity.setAmount(model.getAmount());
        entity.setUserId(1);
        entity.setName(model.getName());

        _IAccountRepository.save(entity);
    }

    @Override
    public void update(AccountModel model) {
        Account entity = _IAccountRepository.findFirstById(model.getId());
        entity.setAccountTypeId(model.getAccountTypeId());
        entity.setDefault(model.isDefault());
        entity.setAmount(model.getAmount());
        entity.setUserId(1);
        entity.setName(model.getName());
        _IAccountRepository.save(entity);
    }

    @Override
    public void delete(AccountModel model) {

    }
}
