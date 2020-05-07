package com.example.demo.services;

import com.example.demo.entities.ExpenseType;
import com.example.demo.interfaces.IExpenseType;
import com.example.demo.models.ExpenseTypeModel;
import com.example.demo.repository.ExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseTypeService implements IExpenseType {

    private final ExpenseTypeRepository _expenseTypeRepository;

    @Autowired
    public ExpenseTypeService(ExpenseTypeRepository expenseTypeRepository) {
        _expenseTypeRepository = expenseTypeRepository;
    }

    @Override
    public List<ExpenseTypeModel> get() {
        return _expenseTypeRepository.findAll().stream().map(x ->
                new ExpenseTypeModel(x.getId(),x.getUserId(),x.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ExpenseTypeModel> getByUserId(int userId) {
        return _expenseTypeRepository.findAllByUserId(userId).stream().map(x ->
                new ExpenseTypeModel(x.getId(),x.getUserId(),x.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseTypeModel getById(int id) {
        ExpenseType entity = _expenseTypeRepository.findFirstById(id);
        return new ExpenseTypeModel(entity.getId(),
                entity.getUserId(),entity.getName());
    }

    @Override
    public void insert(ExpenseTypeModel model) {
        ExpenseType entity = new ExpenseType(model.getName());
        entity.setUserId(1);
        _expenseTypeRepository.save(entity);
    }

    @Override
    public void update(ExpenseTypeModel model) {
        ExpenseType entity = _expenseTypeRepository.findFirstById(model.getId());

        entity.setName(model.getName());
        _expenseTypeRepository.save(entity);
    }

    @Override
    public void delete(ExpenseTypeModel model) {

    }
}