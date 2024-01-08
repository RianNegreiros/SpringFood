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

    private String name;

    private String description;

    private Double deliveryTax;

    private String city;

    private String neighborhood;

    private String street;

    private String number;

    public Restaurant() {
    }

    public Restaurant(Long id, Category category, List<ProductCategory> productCategories, List<Order> orders, Image image, String name, Double deliveryTax, String city, String neighborhood, String street, String number) {
        this.id = id;
        this.category = category;
        this.productCategories = productCategories;
        this.orders = orders;
        this.image = image;
        this.name = name;
        this.deliveryTax = deliveryTax;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDeliveryTax() {
        return deliveryTax;
    }

    public void setDeliveryTax(Double deliveryTax) {
        this.deliveryTax = deliveryTax;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}