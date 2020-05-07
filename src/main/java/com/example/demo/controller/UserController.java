package com.example.demo.controller;

import com.example.demo.interfaces.IUserService;
import com.example.demo.models.LoginModel;
import com.example.demo.models.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

private final IUserService _userService;

    @Autowired
    public UserController(IUserService userService) {
        _userService = userService;
    }

    @PostMapping
    @RequestMapping("/login")
    public String Login(@RequestBody LoginModel model){
        return _userService.Login(model);
    }

    @PostMapping
    @RequestMapping("/register")
    public Boolean Register(@RequestBody RegisterModel model){
        return _userService.Register(model);
    }

}
