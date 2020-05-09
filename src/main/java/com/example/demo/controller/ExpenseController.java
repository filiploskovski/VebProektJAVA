package com.example.demo.controller;

import com.example.demo.interfaces.IExpense;
import com.example.demo.models.ExpenseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final IExpense _IExpense;

    @Autowired
    public ExpenseController(IExpense iExpense) {
        _IExpense = iExpense;
    }

    @GetMapping
    @RequestMapping("/get")
    public List<ExpenseModel> get(){
        return _IExpense.getByUserId();
    }

    @PostMapping
    @RequestMapping("/get-by-id")
    public ExpenseModel getById(@RequestBody ExpenseModel model){
        return _IExpense.getById(model.getId());
    }

    @PostMapping
    public void insert(@RequestBody ExpenseModel model){
        _IExpense.insert(model);
    }

    @PutMapping
    public void update(@RequestBody ExpenseModel model){
        _IExpense.update(model);
    }

    @DeleteMapping
    public void delete(@RequestParam int id){
        _IExpense.delete(id);
    }
}
