package com.javahack.demo.models.bankoperation;

import com.javahack.demo.models.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credit_requests")
public class CreditRequest  {
    public CreditRequest() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_req_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user_req;
    private Date dueTo;
    private Long value;
    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "creditRequest")
    private CreditResponse creditResponse;

    public User getUser_req() {
        return user_req;
    }

    public void setUser_req(User user_req) {
        this.user_req = user_req;
    }

    public CreditResponse getCreditResponse() {
        return creditResponse;
    }

    public void setCreditResponse(CreditResponse creditResponse) {
        this.creditResponse = creditResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user_req;
    }

    public void setUser(User user_req) {
        this.user_req = user_req;
    }

    public Date getDueTo() {
        return dueTo;
    }

    public void setDueTo(Date dueTo) {
        this.dueTo = dueTo;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public CreditRequest(User user_req, Date dueTo, Long value, CreditResponse creditResponse) {
        this.user_req = user_req;
        this.dueTo = dueTo;
        this.value = value;
        this.creditResponse = creditResponse;
    }
}
