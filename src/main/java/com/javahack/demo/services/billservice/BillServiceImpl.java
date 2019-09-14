package com.javahack.demo.services.billservice;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.User;
import com.javahack.demo.repos.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public void delete(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Bill findBillById(Integer id) {
        return billRepository.findBillById(id);
    }

    @Override
    public List<Bill> findBillsByHolder(User user) {
        return billRepository.findBillsByHolder(user);
    }
}
