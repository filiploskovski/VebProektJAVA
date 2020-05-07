package com.example.demo.controller;

import com.example.demo.entities.Account;
import com.example.demo.interfaces.IAccount;
import com.example.demo.models.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    private final IAccount _IAccount;

    @Autowired
    public AccountController(IAccount iAccount) {
        _IAccount = iAccount;
    }

    @GetMapping
    @RequestMapping("/get")
    public List<AccountModel> get(){
        return _IAccount.get();
    }

    @PostMapping
    @RequestMapping("/get-by-id")
    public AccountModel getById(@RequestBody AccountModel model){
        return _IAccount.getById(model.getId());
    }

    @PostMapping
    public void insert(@RequestBody AccountModel model){
        _IAccount.insert(model);
    }

    @PutMapping
    public void update(@RequestBody AccountModel model){
        _IAccount.update(model);
    }

    @DeleteMapping
    public void delete(@RequestBody AccountModel model){

    }
}
