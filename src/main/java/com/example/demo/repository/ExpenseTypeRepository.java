package com.example.demo.repository;

import com.example.demo.entities.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Integer> {
    List<ExpenseType> findAllByUserId(int userId);
    List<ExpenseType> findAll();
    ExpenseType findFirstById(int id);
}
