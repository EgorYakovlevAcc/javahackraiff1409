package com.javahack.demo.repos;

import com.javahack.demo.models.bankoperation.ValueHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueHistoryRepository extends JpaRepository<ValueHistory, Integer> {
    ValueHistory findValueHistoryById(Integer id);
}
