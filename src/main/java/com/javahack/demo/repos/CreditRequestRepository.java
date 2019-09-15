package com.javahack.demo.repos;

import com.javahack.demo.models.bankoperation.CreditRequest;
import com.javahack.demo.models.bankoperation.CreditResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRequestRepository extends JpaRepository<CreditRequest, Integer> {
    CreditRequest findCreditRequestById(Integer id);
    CreditRequest findCreditRequestByCreditResponse(CreditResponse creditResponse);
}
