package com.javahack.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_catalogs")
public class ProductCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "productCatalog", cascade = CascadeType.ALL)
    private List<Product> products;

    public ProductCatalog() {
    }

    public ProductCatalog(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
