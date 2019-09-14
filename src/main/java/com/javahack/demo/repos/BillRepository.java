package com.javahack.demo.repos;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    Bill findBillById(Integer id);
    List<Bill> findBillsByHolder(User holder);
}
