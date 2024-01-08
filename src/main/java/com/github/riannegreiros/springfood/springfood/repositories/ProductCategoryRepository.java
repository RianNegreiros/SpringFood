package com.github.riannegreiros.springfood.springfood.repositories;

import com.github.riannegreiros.springfood.springfood.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
