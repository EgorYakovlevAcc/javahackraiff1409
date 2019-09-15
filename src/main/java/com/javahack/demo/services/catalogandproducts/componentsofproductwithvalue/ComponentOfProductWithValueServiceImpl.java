package com.javahack.demo.services.catalogandproducts.componentsofproductwithvalue;
import com.javahack.demo.models.ComponentOfProductWithValue;
import com.javahack.demo.models.Product;
import com.javahack.demo.repos.ComponentsOfProductWithValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentOfProductWithValueServiceImpl implements ComponentOfProductWithValueService {
    @Autowired
    private ComponentsOfProductWithValueRepository componentsOfProductWithValueRepository;
    @Override
    public ComponentOfProductWithValue findComponentsOfProductWithValueById(Integer id) {
        return componentsOfProductWithValueRepository.findComponentsOfProductWithValueById(id);
    }

    @Override
    public ComponentOfProductWithValue findComponentsOfProductWithValueByProduct(Product product) {
        return componentsOfProductWithValueRepository.findComponentsOfProductWithValueByProduct(product);
    }

    @Override
    public void save(ComponentOfProductWithValue componentsOfProductWithValue) {
        componentsOfProductWithValueRepository.save(componentsOfProductWithValue);
    }
}
