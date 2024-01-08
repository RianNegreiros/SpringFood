package com.github.riannegreiros.springfood.springfood.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    private String name;

    private Double price;

    private String description;

    public Product() {
    }

    public Product(Long id, ProductCategory productCategory, List<OrderProduct> orderProducts, Image image, String name, Double price) {
        this.id = id;
        this.productCategory = productCategory;
        this.orderProducts = orderProducts;
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    private void validateNameAndPrice() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }
}