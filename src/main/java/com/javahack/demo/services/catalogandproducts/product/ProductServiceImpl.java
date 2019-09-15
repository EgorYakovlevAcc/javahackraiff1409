package com.javahack.demo.services.catalogandproducts.product;

import com.javahack.demo.models.Product;
import com.javahack.demo.models.ProductCatalog;
import com.javahack.demo.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product findProductById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> findProductsByProductCatalog(ProductCatalog productCatalog) {
        return productRepository.findProductsByProductCatalog(productCatalog);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
