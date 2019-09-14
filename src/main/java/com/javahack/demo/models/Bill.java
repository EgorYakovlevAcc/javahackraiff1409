package com.javahack.demo.models;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

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

    public Long getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(Long moneyValue) {
        this.moneyValue = moneyValue;
    }

    private Long moneyValue;

    public Bill() {
    }

    public Bill(User holder, Date createDate, Long moneyValue) {
        this.holder = holder;
        this.createDate = createDate;
        this.moneyValue = moneyValue;
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
}
