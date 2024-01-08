package com.github.riannegreiros.springfood.springfood.services;


import com.github.riannegreiros.springfood.springfood.entities.Restaurant;
import com.github.riannegreiros.springfood.springfood.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
