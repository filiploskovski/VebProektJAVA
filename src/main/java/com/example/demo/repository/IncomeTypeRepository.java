package com.example.demo.repository;

import com.example.demo.entities.IncomeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IncomeTypeRepository extends JpaRepository<IncomeType,Integer> {
    List<IncomeType> findAll();
    List<IncomeType> findAllByUserId(int userId);
    IncomeType findFirstById(int id);
}
