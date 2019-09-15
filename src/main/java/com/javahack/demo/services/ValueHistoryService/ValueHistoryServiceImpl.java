package com.javahack.demo.services.ValueHistoryService;

import com.javahack.demo.models.bankoperation.ValueHistory;
import com.javahack.demo.repos.ValueHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueHistoryServiceImpl implements ValueHistoryService {
    @Autowired
    private ValueHistoryRepository valueHistoryRepository;
    @Override
    public ValueHistory findValueHistoryById(Integer id) {
        return valueHistoryRepository.findValueHistoryById(id);
    }
}
