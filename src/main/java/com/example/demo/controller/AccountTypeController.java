package com.example.demo.controller;

import com.example.demo.interfaces.IAccountType;
import com.example.demo.models.AccountTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-type")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountTypeController {

    private final IAccountType _IAccountType;

    @Autowired
    public AccountTypeController(IAccountType iAccountType) {
        _IAccountType = iAccountType;
    }

    @GetMapping
    @RequestMapping("/get")
    public List<AccountTypeModel> get(){
        return _IAccountType.get();
    }

    @PostMapping
    @RequestMapping("/get-by-id")
    public AccountTypeModel getById(@RequestBody AccountTypeModel model){
        return _IAccountType.getById(model.getId());
    }

    @PostMapping
    public void insert(@RequestBody AccountTypeModel model){
        _IAccountType.insert(model);
    }

    @PutMapping
    public void update(@RequestBody AccountTypeModel model) {_IAccountType.update(model);}

    @DeleteMapping
    public void delete(@RequestBody AccountTypeModel model){
        _IAccountType.delete(model);
    }


}
