package com.javahack.demo.models.bankoperation;

import com.javahack.demo.models.Bill;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction extends BankOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date date = new Date();
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_bill_id", nullable = false)
    private Bill fromBill;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_bill_id", nullable = false)
    private Bill toBill;
    private Long value;
    private Operation operation;

    public Transaction(Date date, Bill fromBill, Bill toBill, Long value, Operation operation) {
        this.date = date;
        this.fromBill = fromBill;
        this.toBill = toBill;
        this.value = value;
        this.operation = operation;
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
