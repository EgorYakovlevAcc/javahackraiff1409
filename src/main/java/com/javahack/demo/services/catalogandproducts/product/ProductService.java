package com.javahack.demo.services.catalogandproducts.product;

import com.javahack.demo.models.Product;
import com.javahack.demo.models.ProductCatalog;

import java.util.List;

public interface ProductService {
    Product findProductById(Integer id);
    List<Product> findProductsByProductCatalog(ProductCatalog productCatalog);
    void save(Product product);
}
