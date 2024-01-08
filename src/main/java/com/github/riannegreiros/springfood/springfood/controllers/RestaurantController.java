package com.github.riannegreiros.springfood.springfood.controllers;

import com.github.riannegreiros.springfood.springfood.entities.Restaurant;
import com.github.riannegreiros.springfood.springfood.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping
    public ResponseEntity<Page<Restaurant>> listRestaurants(
            @RequestParam(name = "q", required = false) String query,
            @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());

        Page<Restaurant> restaurants = restaurantRepository.findAll(pageable);

        if (query != null) {
            restaurants = restaurantRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query, pageable);
        }

        if (city != null) {
            restaurants = restaurantRepository.findByCityIgnoreCase(city, pageable);
        }

        if (category != null) {
            restaurants = restaurantRepository.findByCategoryTitleIgnoreCase(category, pageable);
        }

        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        return restaurantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}