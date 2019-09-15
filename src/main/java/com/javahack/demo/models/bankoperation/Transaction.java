package com.javahack.demo.models.bankoperation;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.TransactionType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Transaction extends BankOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date date = new Date();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_bill_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bill fromBill;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_bill_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bill toBill;
    private Long value;
    private Operation operation;
    private TransactionType transactionType;

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Transaction(Date date, Bill fromBill, Bill toBill, Long value, Operation operation, TransactionType transactionType) {
        this.date = date;
        this.fromBill = fromBill;
        this.toBill = toBill;
        this.value = value;
        this.operation = operation;
        this.transactionType = transactionType;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Bill getFromBill() {
        return fromBill;
    }

    public void setFromBill(Bill fromBill) {
        this.fromBill = fromBill;
    }

    public Bill getToBill() {
        return toBill;
    }

    public void setToBill(Bill toBill) {
        this.toBill = toBill;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Transaction() {
    }

    public Transaction(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
