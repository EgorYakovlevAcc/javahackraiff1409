package com.javahack.demo.services.ValueHistoryService;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.bankoperation.ValueHistory;
import com.javahack.demo.repos.ValueHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValueHistoryServiceImpl implements ValueHistoryService {
    @Autowired
    private ValueHistoryRepository valueHistoryRepository;
    @Override
    public ValueHistory findValueHistoryById(Integer id) {
        return valueHistoryRepository.findValueHistoryById(id);
    }

    @Override
    public List<ValueHistory> findValueHistoriesByBill(Bill bill) {
        return valueHistoryRepository.findValueHistoriesByBill(bill);
    }

    @Override
    public void save(ValueHistory valueHistory) {
        valueHistoryRepository.save(valueHistory);
    }
}
