package com.javahack.demo.repos;

import com.javahack.demo.models.ComponentOfProductWithValue;
import com.javahack.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentsOfProductWithValueRepository extends JpaRepository<ComponentOfProductWithValue, Integer> {
    ComponentOfProductWithValue findComponentsOfProductWithValueById(Integer id);
    ComponentOfProductWithValue findComponentsOfProductWithValueByProduct (Product product);
}
