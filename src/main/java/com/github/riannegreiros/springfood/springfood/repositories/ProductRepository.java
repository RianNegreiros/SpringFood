package com.github.riannegreiros.springfood.springfood.repositories;

import com.github.riannegreiros.springfood.springfood.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
