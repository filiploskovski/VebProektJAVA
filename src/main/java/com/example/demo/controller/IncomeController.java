package com.example.demo.controller;

import com.example.demo.interfaces.IIncome;
import com.example.demo.models.IncomeModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    private final IIncome _IIncome;

    public IncomeController(IIncome iIncome) {
        _IIncome = iIncome;
    }

    @GetMapping
    @RequestMapping("/get")
    public List<IncomeModel> get(){
        return _IIncome.get();
    }

    @PostMapping
    @RequestMapping("/get-by-id")
    public IncomeModel getById(@RequestBody IncomeModel model){
        return _IIncome.getById(model.getId());
    }

    @PostMapping
    public void insert(@RequestBody IncomeModel model){
        _IIncome.insert(model);
    }

    @PutMapping
    public void update(@RequestBody IncomeModel model){
        _IIncome.update(model);
    }

    @DeleteMapping
    public void delete(@RequestParam int id){
        _IIncome.delete(id);
    }
}
