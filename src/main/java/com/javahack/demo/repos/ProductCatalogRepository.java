package com.javahack.demo.repos;

import com.javahack.demo.models.ProductCatalog;
import com.javahack.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Integer> {
    ProductCatalog findProductCatalogById(Integer id);
    List<ProductCatalog> findProductCatalogsByUser(User user);
}
