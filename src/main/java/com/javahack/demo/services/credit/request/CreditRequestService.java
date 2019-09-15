package com.javahack.demo.services.credit.request;

import com.javahack.demo.models.bankoperation.CreditRequest;
import com.javahack.demo.models.bankoperation.CreditResponse;

public interface CreditRequestService {
    void save(CreditRequest creditRequest);
    CreditRequest findCreditRequestById(Integer id);
    CreditRequest findCreditRequestByCreditResponse(CreditResponse creditResponse);
}
