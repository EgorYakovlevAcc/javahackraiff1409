package com.javahack.demo.models.bankoperation;

import com.javahack.demo.models.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "credit_responses")
public class CreditResponse {
    public User getUser_resp() {
        return user_resp;
    }

    public void setUser_resp(User user_resp) {
        this.user_resp = user_resp;
    }

    public CreditResponse() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_resp_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user_resp;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "credit_request_id", nullable = false)
    private CreditRequest creditRequest;
    private boolean answer;

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public CreditResponse(User user_resp, CreditRequest creditRequest, boolean answer) {
        this.user_resp = user_resp;
        this.creditRequest = creditRequest;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user_resp;
    }

    public void setUser(User user_resp) {
        this.user_resp = user_resp;
    }

    public CreditRequest getCreditRequest() {
        return creditRequest;
    }

    public void setCreditRequest(CreditRequest creditRequest) {
        this.creditRequest = creditRequest;
    }
}
