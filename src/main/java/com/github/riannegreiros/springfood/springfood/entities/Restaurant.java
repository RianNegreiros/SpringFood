package com.github.riannegreiros.springfood.springfood.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tb_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "restaurant")
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public Restaurant() {
    }

    public Restaurant(Long id, Category category, List<ProductCategory> productCategories, List<Order> orders, Image image) {
        this.id = id;
        this.category = category;
        this.productCategories = productCategories;
        this.orders = orders;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}