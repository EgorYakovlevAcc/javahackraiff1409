package com.javahack.demo.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_catalog_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductCatalog productCatalog;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ComponentOfProductWithValue> componentsOfProductWithValue;

    public Product() {
    }

    public Product(ProductCatalog productCatalog, List<ComponentOfProductWithValue> componentsOfProductWithValue) {
        this.productCatalog = productCatalog;
        this.componentsOfProductWithValue = componentsOfProductWithValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public List<ComponentOfProductWithValue> getComponentsOfProductWithValue() {
        return componentsOfProductWithValue;
    }

    public void setComponentsOfProductWithValue(List<ComponentOfProductWithValue> componentsOfProductWithValue) {
        this.componentsOfProductWithValue = componentsOfProductWithValue;
    }
}
