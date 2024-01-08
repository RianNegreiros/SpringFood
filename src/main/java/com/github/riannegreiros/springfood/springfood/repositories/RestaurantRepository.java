package com.github.riannegreiros.springfood.springfood.repositories;

import com.github.riannegreiros.springfood.springfood.entities.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Page<Restaurant> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description, Pageable pageable);

    Page<Restaurant> findByCityIgnoreCase(String city, Pageable pageable);

    Page<Restaurant> findByCategoryTitleIgnoreCase(String categoryTitle, Pageable pageable);
}
