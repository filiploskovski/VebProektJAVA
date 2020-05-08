package com.example.demo.generic;

import java.util.List;

public interface IGenericInterface<T> {
    List<T> get();
    List<T> getByUserId();
    T getById(int id);
    void insert(T model);
    void update(T model);
    void delete(int id);


}
