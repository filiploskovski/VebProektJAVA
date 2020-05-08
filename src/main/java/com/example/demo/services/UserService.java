package com.example.demo.services;

import com.example.demo.JWT.JwtUtil;
import com.example.demo.JWT.MyUserDetailsService;
import com.example.demo.entities.User;
import com.example.demo.exception.MyCustomException;
import com.example.demo.interfaces.IUserService;
import com.example.demo.models.LoginModel;
import com.example.demo.models.RegisterModel;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService {

    private final UserRepository _userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetails;

    @Autowired
    private JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        _userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean Register(RegisterModel model) throws MyCustomException {
        User email = _userRepository.findFirstByEmail(model.getEmail());
        User username = _userRepository.findFirstByUsername(model.getUsername());

        if(email != null || username != null)
            throw new MyCustomException("Same username or email");

        User user = new User();
        user.setEmail(model.getEmail());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        user.setUsername(model.getUsername());
        _userRepository.save(user);

        return user.getId() > 0;
    }

    @Override
    public String Login(LoginModel model) throws MyCustomException {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(model.getName()
                    ,model.getPassword()));
        }catch (BadCredentialsException e){
            throw new MyCustomException("Same username or email");
        }

        UserDetails user = userDetails.loadUserByUsername(model.getName());
        User userForId = _userRepository.findFirstByUsername(model.getName());

        Map<String, Object> claims = new HashMap<>();
        claims.put("Id",userForId.getId());

        String jwt = jwtUtil.generateToken(user,claims);

        Object obj = new Object(){
            String Token = jwt;
            String Username = model.getName();
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
