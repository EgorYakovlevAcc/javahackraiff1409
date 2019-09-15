package com.javahack.demo.services.catalogandproducts.componentsofproductwithvalue;

import com.javahack.demo.models.ComponentOfProductWithValue;
import com.javahack.demo.models.Product;

public interface ComponentOfProductWithValueService {
    ComponentOfProductWithValue findComponentsOfProductWithValueById(Integer id);
    ComponentOfProductWithValue findComponentsOfProductWithValueByProduct (Product product);
    void save(ComponentOfProductWithValue componentsOfProductWithValue);
}
