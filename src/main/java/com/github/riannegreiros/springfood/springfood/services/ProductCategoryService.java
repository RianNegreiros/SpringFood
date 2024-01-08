package com.github.riannegreiros.springfood.springfood.services;

import com.github.riannegreiros.springfood.springfood.entities.ProductCategory;
import com.github.riannegreiros.springfood.springfood.entities.Restaurant;
import com.github.riannegreiros.springfood.springfood.repositories.ProductCategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Transactional
    public ProductCategory save(String title, Restaurant restaurant) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setTitle(title);
        productCategory.setRestaurant(restaurant);

        return productCategoryRepository.save(productCategory);
    }
}
