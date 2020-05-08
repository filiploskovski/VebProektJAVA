package com.example.demo.services;

import com.example.demo.JWT.ClaimsService;
import com.example.demo.entities.IncomeType;
import com.example.demo.interfaces.IIncomeType;
import com.example.demo.models.IncomeTypeModel;
import com.example.demo.repository.IncomeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeTypeService implements IIncomeType {

    private final IncomeTypeRepository _inIncomeTypeRepository;
    private final ClaimsService claimsService;

    @Autowired
    public IncomeTypeService(IncomeTypeRepository inIncomeTypeRepository, ClaimsService claimsService) {
        _inIncomeTypeRepository = inIncomeTypeRepository;
        this.claimsService = claimsService;
    }

    @Override
    public List<IncomeTypeModel> get() {
        return _inIncomeTypeRepository.findAll().stream().map(x ->
                new IncomeTypeModel(x.getId(),x.getUserId(),x.getName())).collect(Collectors.toList());
    }

    @Override
    public List<IncomeTypeModel> getByUserId() {
        return _inIncomeTypeRepository.findAllByUserId(claimsService.GetUserIdFromToken()).stream().map(x ->
                new IncomeTypeModel(x.getId(),x.getUserId(),x.getName())).collect(Collectors.toList());
    }

    @Override
    public IncomeTypeModel getById(int id) {
        IncomeType entity = _inIncomeTypeRepository.findFirstById(id);
        return new IncomeTypeModel(entity.getId(),entity.getUserId(),entity.getName());
    }

    @Override
    public void insert(IncomeTypeModel model) {
        IncomeType entity = new IncomeType(model.getName());
        entity.setUserId(claimsService.GetUserIdFromToken());
        _inIncomeTypeRepository.save(entity);
    }

    @Override
    public void update(IncomeTypeModel model) {
        IncomeType entity = _inIncomeTypeRepository.findFirstById(model.getId());
        entity.setName(model.getName());
        _inIncomeTypeRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        IncomeType entity = _inIncomeTypeRepository.findFirstById(id);
        _inIncomeTypeRepository.delete(entity);
    }
}
