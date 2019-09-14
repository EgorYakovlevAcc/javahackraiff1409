package com.javahack.demo.services.transaction;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.bankoperation.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {
    void save(Transaction transaction);
    void delete(Transaction transaction);

    Transaction findTransactionById(Integer id);
    Transaction findByDate(Date date);
    List<Transaction> findTransactionsByFromBillAndToBill (Bill fromBill, Bill toBill);
    List<Transaction> findTransactionsByFromBill (Bill fromBill);
    List<Transaction> findTransactionsByToBill (Bill toBill);
}
