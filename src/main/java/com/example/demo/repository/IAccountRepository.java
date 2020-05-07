package com.example.demo.repository;

import com.example.demo.entities.Account;
import com.example.demo.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Integer> {
    Account findFirstById(int id);
    List<Account> findAllByUserId(int userId);
}
