package com.github.riannegreiros.springfood.springfood.repositories;

import com.github.riannegreiros.springfood.springfood.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
