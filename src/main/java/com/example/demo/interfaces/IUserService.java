package com.example.demo.interfaces;

import com.example.demo.exception.MyCustomException;
import com.example.demo.models.LoginModel;
import com.example.demo.models.RegisterModel;

public interface IUserService {

    boolean Register(RegisterModel model) throws MyCustomException;
    String Login(LoginModel model) throws MyCustomException;
}
