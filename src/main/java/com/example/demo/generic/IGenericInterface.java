package com.example.demo.generic;

import java.util.List;

public interface IGenericInterface<T> {
    List<T> get();
    List<T> getByUserId(int userId);
    T getById(int id);
    void insert(T model);
    void update(T model);
    void delete(T model);


}
