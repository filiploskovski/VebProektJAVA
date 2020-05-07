package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountTypeModel {

    @JsonProperty("Id")
    private int id;
    @JsonProperty("UserId")
    private int userId;
    @JsonProperty("Name")
    private String name;

    public AccountTypeModel(@JsonProperty("UserId") int userId, @JsonProperty("Name") String name) {
        this.userId = userId;
        this.name = name;
    }

    public AccountTypeModel(int id, int userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
