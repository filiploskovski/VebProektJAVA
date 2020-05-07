package com.example.demo.repository;

import com.example.demo.entities.AccountType;
import com.example.demo.entities.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {
    List<AccountType> findAllByUserId(int userId);
    List<AccountType> findAll();
    AccountType findFirstById(int id);
}
