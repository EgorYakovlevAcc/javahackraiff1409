package com.javahack.demo.repos;

import com.javahack.demo.models.Product;
import com.javahack.demo.models.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductById(Integer id);
    List<Product> findProductsByProductCatalog(ProductCatalog productCatalog);
}
