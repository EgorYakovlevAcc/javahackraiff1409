package com.javahack.demo.repos;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.bankoperation.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findTransactionById(Integer id);
    Transaction findByDate(Date date);
    List<Transaction> findTransactionsByFromBillAndToBill (Bill fromBill, Bill toBill);
    List<Transaction> findTransactionsByFromBill (Bill fromBill);
    List<Transaction> findTransactionsByToBill (Bill toBill);
}
