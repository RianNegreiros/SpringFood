package com.github.riannegreiros.springfood.springfood.services;

import com.github.riannegreiros.springfood.springfood.entities.Category;
import com.github.riannegreiros.springfood.springfood.entities.Image;
import com.github.riannegreiros.springfood.springfood.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public Category save(String title, MultipartFile imageFile) {
        try {
            Category category = new Category();
            category.setTitle(title);

            Image imageEntity = new Image();
            imageEntity.setImageName(imageFile.getOriginalFilename());
            imageEntity.setContentType(imageFile.getContentType());
            imageEntity.setData(imageFile.getBytes());

            category.setImage(imageEntity);

            return categoryRepository.save(category);
        } catch (IOException e) {
            throw new RuntimeException("Error processing image file", e);
        }
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}
