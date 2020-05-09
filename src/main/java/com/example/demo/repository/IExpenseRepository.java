package com.example.demo.repository;

import com.example.demo.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IExpenseRepository extends JpaRepository<Expense,Integer> {
    Expense findFirstById(int id);
    //List<Expense> findAllByAccountIdInAndDate(List<Integer> accountId, Date date);
    List<Expense> findAllByAccountIdInAndDateIsBetween(List<Integer> accountId, Date startDate, Date endDate);
    List<Expense> findAllByAccountIdIn(List<Integer> accountId);

}
