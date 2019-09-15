package com.javahack.demo.services.ValueHistoryService;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.bankoperation.ValueHistory;

import java.util.List;

public interface ValueHistoryService {
    ValueHistory findValueHistoryById(Integer id);
    List<ValueHistory> findValueHistoriesByBill(Bill bill);
    void save(ValueHistory valueHistory);
}
