package com.example.demo.repository;

import com.example.demo.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IIncomeRepository extends JpaRepository<Income,Integer> {
    List<Income> findAll();
    Income findFirstById(int id);
    List<Income> findAllByAccountIdInOrderByDateDesc(List<Integer> accountId);
    List<Income> findAllByAccountIdInAndDateBetween(List<Integer> accountId, Date startDate, Date endDate);
    List<Income> findAllByAccountIdIn(List<Integer> accountId);


}
