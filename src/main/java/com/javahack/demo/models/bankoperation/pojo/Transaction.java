package com.javahack.demo.models.bankoperation.pojo;

import java.util.Date;

public class Transaction {
    private Long value;
    private Date date;

    public Transaction() {
    }

    public Transaction(Long value, Date date) {
        this.value = value;
        this.date = date;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
