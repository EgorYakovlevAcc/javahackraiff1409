package com.javahack.demo.models;

import com.javahack.demo.models.bankoperation.Transaction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "holder_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User holder;
    private Date createDate;
    @OneToMany(mappedBy = "fromBill", cascade = CascadeType.ALL)
    private List<Transaction> fromTransactions;
    @OneToMany(mappedBy = "toBill", cascade = CascadeType.ALL)
    private List<Transaction> toTransactions;

    public List<Transaction> getFromTransactions() {
        return fromTransactions;
    }

    public void setFromTransactions(List<Transaction> fromTransactions) {
        this.fromTransactions = fromTransactions;
    }

    public List<Transaction> getToTransactions() {
        return toTransactions;
    }

    public void setToTransactions(List<Transaction> toTransactions) {
        this.toTransactions = toTransactions;
    }

    public Long getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(Long moneyValue) {
        this.moneyValue = moneyValue;
    }

    private Long moneyValue;

    public Bill() {
    }

    public Bill(User holder, Date createDate, Long moneyValue, List<Transaction> toTransactions, List<Transaction> fromTransactions) {
        this.holder = holder;
        this.createDate = createDate;
        this.moneyValue = moneyValue;
        this.toTransactions = toTransactions;
        this.fromTransactions = fromTransactions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Transaction> getAllTransactionsForBill() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(this.fromTransactions);
        transactions.addAll(this.toTransactions);
        return transactions;
    }
}
