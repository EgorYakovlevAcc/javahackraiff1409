package com.javahack.demo.models.bankoperation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transaction extends BankOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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

    private Date date;

}
