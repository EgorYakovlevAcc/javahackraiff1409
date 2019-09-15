package com.javahack.demo.services.catalogandproducts;

import com.javahack.demo.models.ProductCatalog;
import com.javahack.demo.models.User;

import java.util.List;

public interface ProductCatalogService {
    ProductCatalog findProductCatalogById(Integer id);
    List<ProductCatalog> findProductCatalogsByUser(User user);
    void save (ProductCatalog productCatalog);
}
