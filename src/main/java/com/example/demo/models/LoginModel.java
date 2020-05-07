package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginModel {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginModel(@JsonProperty("username")String name, @JsonProperty("password")String password) {
        this.name = name;
        this.password = password;
    }

    private String name;
    private String password;


}
