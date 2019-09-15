package com.javahack.demo.services.catalogandproducts;

import com.javahack.demo.models.ProductCatalog;
import com.javahack.demo.models.User;
import com.javahack.demo.repos.ProductCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {
    @Autowired
    private ProductCatalogRepository productCatalogRepository;
    @Override
    public ProductCatalog findProductCatalogById(Integer id) {
        return productCatalogRepository.findProductCatalogById(id);
    }

    @Override
    public List<ProductCatalog> findProductCatalogsByUser(User user) {
        return productCatalogRepository.findProductCatalogsByUser(user);
    }

    @Override
    public void save(ProductCatalog productCatalog) {
        productCatalogRepository.save(productCatalog);
    }
}
