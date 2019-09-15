package com.javahack.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "components_of_products_with_value")
public class ComponentsOfProductWithValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Product product;
    private Integer value;

    public ComponentsOfProductWithValue() {
    }

    public ComponentsOfProductWithValue(Product product, Integer value) {
        this.product = product;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
