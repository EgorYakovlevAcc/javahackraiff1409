package com.javahack.demo.services.credit.request;

import com.javahack.demo.models.bankoperation.CreditRequest;
import com.javahack.demo.models.bankoperation.CreditResponse;
import com.javahack.demo.repos.CreditRequestRepository;
import com.javahack.demo.repos.CreditResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditRequestServiceImpl implements CreditRequestService {
    @Autowired
    private CreditRequestRepository creditRequestRepository;

    @Override
    public void save(CreditRequest creditRequest) {
        creditRequestRepository.save(creditRequest);
    }

    @Override
    public CreditRequest findCreditRequestById(Integer id) {
        return creditRequestRepository.findCreditRequestById(id);
    }

    @Override
    public CreditRequest findCreditRequestByCreditResponse(CreditResponse creditResponse) {
        return creditRequestRepository.findCreditRequestByCreditResponse(creditResponse);
    }
}
