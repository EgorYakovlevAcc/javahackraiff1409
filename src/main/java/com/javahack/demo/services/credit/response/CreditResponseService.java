package com.javahack.demo.services.credit.response;

import com.javahack.demo.models.bankoperation.CreditRequest;
import com.javahack.demo.models.bankoperation.CreditResponse;

public interface CreditResponseService {
    void save(CreditResponse creditResponse);
    CreditResponse findCreditResponseById(Integer id);
    CreditResponse findCreditResponseByCreditRequest(CreditRequest creditRequest);
}
