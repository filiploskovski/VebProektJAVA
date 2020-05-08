package com.example.demo.controller;

import com.example.demo.interfaces.IIncomeType;
import com.example.demo.models.IncomeTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income-type")
public class IncomeTypeController {

    private final IIncomeType _IIncomeType;

    @Autowired
    public IncomeTypeController(IIncomeType iIncomeType) {
        _IIncomeType = iIncomeType;
    }

    @GetMapping
    @RequestMapping("/get")
    public List<IncomeTypeModel> get(){
        return _IIncomeType.getByUserId();
    }

    @PostMapping
    @RequestMapping("/get-by-id")
    public IncomeTypeModel getById(@RequestBody IncomeTypeModel model){
        return _IIncomeType.getById(model.getId());
    }

    @PostMapping
    public void insert(@RequestBody IncomeTypeModel model){
        _IIncomeType.insert(model);
    }

    @PutMapping
    public void update(@RequestBody IncomeTypeModel model){
        _IIncomeType.update(model);
    }

    @DeleteMapping
    public void delete(@RequestParam int id){
        _IIncomeType.delete(id);
    }
}
