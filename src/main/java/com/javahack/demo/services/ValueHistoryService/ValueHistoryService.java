package com.javahack.demo.services.ValueHistoryService;

import com.javahack.demo.models.bankoperation.ValueHistory;

public interface ValueHistoryService {
    ValueHistory findValueHistoryById(Integer id);
}
