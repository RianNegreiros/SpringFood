package com.github.riannegreiros.springfood.springfood.services;


import com.github.riannegreiros.springfood.springfood.entities.Category;
import com.github.riannegreiros.springfood.springfood.entities.Image;
import com.github.riannegreiros.springfood.springfood.entities.Restaurant;
import com.github.riannegreiros.springfood.springfood.repositories.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Transactional
    public Restaurant save(String name, String description, Double deliveryTax, String city, String street, String number, String neighborhood, Category category, MultipartFile imageFile) {
        try {
            Restaurant restaurant = new Restaurant();
            restaurant.setName(name);
            restaurant.setDescription(description);
            restaurant.setDeliveryTax(deliveryTax);
            restaurant.setCity(city);
            restaurant.setStreet(street);
            restaurant.setNumber(number);
            restaurant.setNeighborhood(neighborhood);
            restaurant.setCategory(category);

            Image imageEntity = new Image();
            imageEntity.setImageName(imageFile.getOriginalFilename());
            imageEntity.setContentType(imageFile.getContentType());
            imageEntity.setData(imageFile.getBytes());

            restaurant.setImage(imageEntity);

            return restaurantRepository.save(restaurant);
        }
        catch (IOException e) {
            throw new RuntimeException("Error processing image file", e);
        }
        }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
