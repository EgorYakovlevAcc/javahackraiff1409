package com.javahack.demo.services.credit.response;

import com.javahack.demo.models.bankoperation.CreditRequest;
import com.javahack.demo.models.bankoperation.CreditResponse;
import com.javahack.demo.repos.CreditResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditResponseServiceImpl implements CreditResponseService {
    @Autowired
    private CreditResponseRepository creditResponseRepository;

    @Override
    public void save(CreditResponse creditResponse) {
        creditResponseRepository.save(creditResponse);
    }

    @Override
    public CreditResponse findCreditResponseById(Integer id) {
        return creditResponseRepository.findCreditResponseById(id);
    }

    @Override
    public CreditResponse findCreditResponseByCreditRequest(CreditRequest creditRequest) {
        return creditResponseRepository.findCreditResponseByCreditRequest(creditRequest);
    }
}
