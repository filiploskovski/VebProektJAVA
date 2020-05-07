package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.interfaces.IUserService;
import com.example.demo.models.LoginModel;
import com.example.demo.models.RegisterModel;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class UserService implements IUserService {

    private final UserRepository _userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public boolean Register(RegisterModel model) {
        User email = _userRepository.findFirstByEmail(model.getEmail());
        User username = _userRepository.findFirstByUsername(model.getUsername());

        if(email != null || username != null)
            throw new ArithmeticException("Test");

        //TODO: PasswordSALT

        User user = new User();
        user.setEmail(model.getEmail());
        user.setPassword(model.getPassword());
        user.setPasswordSalt(model.getPassword());
        user.setUsername(model.getUsername());
        _userRepository.save(user);

        return user.getId() > 0;
    }

    @Override
    public String Login(LoginModel model) {
        Boolean user = _userRepository.existsUserByUsernameAndPassword(model.getName(),model.getPassword());

        if(user == false)
            throw new ArithmeticException("Test");

        Object obj = new Object(){
            String Token = "token";
            String Username = "filip";
        };

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        String json = "";
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
}
