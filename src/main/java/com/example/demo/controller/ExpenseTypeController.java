package com.example.demo.controller;

import com.example.demo.entities.ExpenseType;
import com.example.demo.interfaces.IExpenseType;
import com.example.demo.models.ExpenseTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-type")
public class ExpenseTypeController {

    private final IExpenseType _expenseTypeService;

    @Autowired
    public ExpenseTypeController(IExpenseType expenseTypeService) {
        _expenseTypeService = expenseTypeService;
    }


    @GetMapping
    @RequestMapping("/get")
    public List<ExpenseTypeModel> get(){
        return _expenseTypeService.getByUserId();
    }

    @GetMapping
    @RequestMapping("/get-by-id")
    public ExpenseTypeModel getById(@RequestBody ExpenseTypeModel model){
        return _expenseTypeService.getById(model.getId());
    }

    @PostMapping
    public void insert(@RequestBody ExpenseTypeModel model){
        _expenseTypeService.insert(model);
    }

    @PutMapping
    public void update(@RequestBody ExpenseTypeModel model) {_expenseTypeService.update(model);}

    @DeleteMapping
    public void delete(@RequestParam int id){
        _expenseTypeService.delete(id);
    }


}
