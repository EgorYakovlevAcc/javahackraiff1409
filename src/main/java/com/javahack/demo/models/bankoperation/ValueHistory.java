package com.javahack.demo.models.bankoperation;

import com.javahack.demo.models.Bill;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "value_history")
public class ValueHistory {
    public ValueHistory() {
    }

    public ValueHistory(Date date, Long value, Bill bill) {
        this.date = date;
        this.value = value;
        this.bill = bill;
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

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date date;
    private Long value;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_acc_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bill bill;
}
