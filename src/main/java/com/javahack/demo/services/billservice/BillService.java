package com.javahack.demo.services.billservice;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.User;

import java.util.List;

public interface BillService {
    void save(Bill bill);
    void delete (Bill bill);
    Bill findBillById(Integer id);
    List<Bill> findBillsByHolder (User user);
}
