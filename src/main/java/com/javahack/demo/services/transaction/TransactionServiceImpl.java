package com.javahack.demo.services.transaction;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.bankoperation.Transaction;
import com.javahack.demo.repos.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    @Override
    public Transaction findTransactionById(Integer id) {
        return transactionRepository.findTransactionById(id);
    }

    @Override
    public Transaction findByDate(Date date) {
        return transactionRepository.findByDate(date);
    }

    @Override
    public List<Transaction> findTransactionsByFromBillAndToBill(Bill fromBill, Bill toBill) {
        return transactionRepository.findTransactionsByFromBillAndToBill(fromBill, toBill);
    }

    @Override
    public List<Transaction> findTransactionsByFromBill(Bill fromBill) {
        return transactionRepository.findTransactionsByFromBill(fromBill);
    }

    @Override
    public List<Transaction> findTransactionsByToBill(Bill toBill) {
        return transactionRepository.findTransactionsByToBill(toBill);
    }
}
