package com.github.riannegreiros.springfood.springfood.services;


import com.github.riannegreiros.springfood.springfood.entities.Category;
import com.github.riannegreiros.springfood.springfood.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
