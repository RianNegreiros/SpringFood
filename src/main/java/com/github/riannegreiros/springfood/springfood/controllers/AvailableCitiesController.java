package com.github.riannegreiros.springfood.springfood.controllers;

import com.github.riannegreiros.springfood.springfood.services.RestaurantService;
import com.github.riannegreiros.springfood.springfood.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/available-cities")
public class AvailableCitiesController {

    private final RestaurantService restaurantService;

    @Autowired
    public AvailableCitiesController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<String> getAvailableCities() {

        return restaurantService.getAllRestaurants()
                .stream()
                .map(Restaurant::getCity)
                .distinct()
                .collect(Collectors.toList());
    }
}