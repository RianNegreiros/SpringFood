package com.github.riannegreiros.springfood.springfood.dto;

import java.util.List;

public class OrderRequest {

    private String name;
    private String phoneNumber;
    private Long restaurantId;
    private String city;
    private String street;
    private String neighborhood;
    private String number;
    private String complement;
    private List<OrderProductRequest> orderProducts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public List<OrderProductRequest> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductRequest> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public static class OrderProductRequest {
        private int quantity;
        private Long productId;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }
    }
}
