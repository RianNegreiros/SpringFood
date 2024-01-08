package com.github.riannegreiros.springfood.springfood.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> products;

    private String title;

    public ProductCategory() {
    }

    public ProductCategory(Long id, Restaurant restaurant, List<Product> products, String title) {
        this.id = id;
        this.restaurant = restaurant;
        this.products = products;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false)
    private void validateTitle() {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }
}