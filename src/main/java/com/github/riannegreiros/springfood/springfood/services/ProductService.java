package com.github.riannegreiros.springfood.springfood.services;

import com.github.riannegreiros.springfood.springfood.entities.Product;
import com.github.riannegreiros.springfood.springfood.entities.Image;
import com.github.riannegreiros.springfood.springfood.entities.ProductCategory;
import com.github.riannegreiros.springfood.springfood.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public Product save(String name, String description, Double price, ProductCategory productCategory, MultipartFile imageFile) {
        try {
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setProductCategory(productCategory);

            Image imageEntity = new Image();
            imageEntity.setImageName(imageFile.getOriginalFilename());
            imageEntity.setContentType(imageFile.getContentType());
            imageEntity.setData(imageFile.getBytes());

            product.setImage(imageEntity);

            return productRepository.save(product);
        }
        catch (IOException e) {
            throw new RuntimeException("Error processing image file", e);
        }
    }
}
