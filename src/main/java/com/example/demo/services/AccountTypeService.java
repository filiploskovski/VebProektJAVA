package com.example.demo.services;

import com.example.demo.entities.AccountType;
import com.example.demo.interfaces.IAccountType;
import com.example.demo.models.AccountTypeModel;
import com.example.demo.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountTypeService implements IAccountType {

    private final AccountTypeRepository _AccountTypeRepository;

    @Autowired
    public AccountTypeService(AccountTypeRepository accountTypeRepository) {
        _AccountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeModel> get() {
        return _AccountTypeRepository.findAll().stream()
                .map(x -> new AccountTypeModel(x.getId(),x.getUserId(),x.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountTypeModel> getByUserId(int userId) {
        return _AccountTypeRepository.findAllByUserId(userId).stream()
                .map(x -> new AccountTypeModel(x.getId(),x.getUserId(),x.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public AccountTypeModel getById(int id) {
        AccountType entity = _AccountTypeRepository.findFirstById(id);
        return new AccountTypeModel(entity.getId(),entity.getUserId(),entity.getName());
    }

    @Override
    public void insert(AccountTypeModel model) {
        AccountType entity = new AccountType(model.getName());
        entity.setUserId(1);
        _AccountTypeRepository.save(entity);
    }

    @Override
    public void update(AccountTypeModel model) {
        AccountType entity = _AccountTypeRepository.findFirstById(model.getId());
        entity.setName(model.getName());
        _AccountTypeRepository.save(entity);
    }

    @Override
    public void delete(AccountTypeModel model) {
    }
}
