package com.github.riannegreiros.springfood.springfood.init;

import com.github.riannegreiros.springfood.springfood.entities.Category;
import com.github.riannegreiros.springfood.springfood.entities.ProductCategory;
import com.github.riannegreiros.springfood.springfood.entities.Restaurant;
import com.github.riannegreiros.springfood.springfood.services.CategoryService;
import com.github.riannegreiros.springfood.springfood.services.ProductCategoryService;
import com.github.riannegreiros.springfood.springfood.services.ProductService;
import com.github.riannegreiros.springfood.springfood.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        seedCategories();
        seedRestaurants();
    }

    private void seedCategories() throws Exception {
        categoryService.save("mexican", createImage("categories/mexican.jpg"));
        categoryService.save("italian", createImage("categories/italian.jpeg"));
        categoryService.save("japanese", createImage("categories/japanese.jpeg"));
        categoryService.save("vegan", createImage("categories/vegan.jpeg"));
        categoryService.save("peruvian", createImage("categories/peruvian.jpg"));
    }

    private void seedRestaurants() throws Exception {
        Category mexicanCategory = categoryService.getByTitle("mexican");
        Restaurant restaurant1 = restaurantService.save(
                "Los Sombreros",
                "Mexican cuisine at its best.",
                5.50,
                "São Paulo",
                "Mercês",
                "1393",
                "Bela terra",
                mexicanCategory,
                createImage("restaurants/1.jpg")
        );
        ProductCategory mexicanDishesCategory1 = productCategoryService.save("Mexican Dishes", restaurant1);
        productService.save("Nacho Guacamole", "Tortillas with Guacamole", 19.0, mexicanDishesCategory1, createImage("products/nachoGuacamole.jpg"));
        productService.save("Nacho", "Tortillas with corn", 19.0, mexicanDishesCategory1, createImage("products/nacho.jpg"));

        Category italianCategory = categoryService.getByTitle("italian");
        Restaurant restaurant3 = restaurantService.save(
                "Bravo",
                "Italian restaurant known for quality ingredients.",
                3.50,
                "São Paulo",
                "Centro",
                "250",
                "Rua via mar",
                italianCategory,
                createImage("restaurants/3.jpg")
        );
        ProductCategory portionsCategory = productCategoryService.save("Portions", restaurant3);
        productService.save("Berinjela à parmegiana", "With rice and fries", 78.0, portionsCategory, createImage("products/berinjelaParmegiana.jpg"));
        productService.save("Fritas", "Bacon fries", 35.0, portionsCategory, createImage("products/fritas.jpg"));

        Category japaneseCategory = categoryService.getByTitle("japanese");
        Restaurant restaurant4 = restaurantService.save(
                "Sushi Eterno",
                "Authentic Japanese sushi and sashimi.",
                7.50,
                "São Paulo",
                "Avenida Manoel Domingos Pinto",
                "507",
                "Parque Anhangüera",
                japaneseCategory,
                createImage("restaurants/4.jpg")
        );
        ProductCategory appetizerCategory = productCategoryService.save("Appetizer", restaurant4);
        productService.save("Temaki", "Rolled rice with seaweed in a cone shape", 19.99, appetizerCategory, createImage("products/temaki.jpg"));
        productService.save("Sashimi", "Sliced raw fish, salmon, tuna and capuchin fish", 30.90, appetizerCategory, createImage("products/sashimi.jpg"));

        Category veganCategory = categoryService.getByTitle("vegan");
        Restaurant restaurant5 = restaurantService.save(
                "Club Life",
                "Vegan dishes with high-quality plant-based ingredients.",
                5.70,
                "São Paulo",
                "Planalto Paulista",
                "933",
                "Alameda dos Uapês",
                veganCategory,
                createImage("restaurants/5.jpg")
        );
        ProductCategory saladsCategory = productCategoryService.save("Salads, sauces and wraps", restaurant5);
        productService.save("Coleslaw", "Red cabbage, kale, carrot, onion, chestnut mayonnaise and xylitol", 8.99, saladsCategory, createImage("products/coleslaw.jpg"));
        productService.save("Side salad", "Mix of leaves with grated carrot, sweet tomato and sunflower seed.", 9.90, saladsCategory, createImage("products/sideSalad.jpg"));
    }

    private MultipartFile createImage(String filename) throws Exception {
        File file = ResourceUtils.getFile("classpath:" + filename);
        byte[] fileContent = Files.readAllBytes(file.toPath());

        String contentType = determineContentType(filename);

        return new MockMultipartFile(filename, filename, contentType, fileContent);
    }

    private String determineContentType(String filename) {
        if (filename.toLowerCase().endsWith(".jpg") || filename.toLowerCase().endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (filename.toLowerCase().endsWith(".png")) {
            return "image/png";
        } else {
            return "application/octet-stream";
        }
    }
}
