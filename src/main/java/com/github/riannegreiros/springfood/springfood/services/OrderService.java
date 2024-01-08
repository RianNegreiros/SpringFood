package com.github.riannegreiros.springfood.springfood.services;

import com.github.riannegreiros.springfood.springfood.dto.OrderRequest;
import com.github.riannegreiros.springfood.springfood.entities.Order;
import com.github.riannegreiros.springfood.springfood.entities.OrderProduct;
import com.github.riannegreiros.springfood.springfood.repositories.OrderRepository;
import com.github.riannegreiros.springfood.springfood.repositories.ProductRepository;
import com.github.riannegreiros.springfood.springfood.repositories.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        order.setName(request.getName());
        order.setPhoneNumber(request.getPhoneNumber());

        order.setRestaurant(restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found")));

        for (OrderRequest.OrderProductRequest orderProductRequest : request.getOrderProducts()) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setQuantity(orderProductRequest.getQuantity());

            orderProduct.setProduct(productRepository.findById(orderProductRequest.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found")));

            orderProduct.setOrder(order);
            order.getOrderProducts().add(orderProduct);
        }

        order.setCity(request.getCity());
        order.setStreet(request.getStreet());
        order.setNeighborhood(request.getNeighborhood());
        order.setNumber(request.getNumber());
        order.setComplement(request.getComplement());

        order.setStatus(Order.OrderStatus.WAITING);

        double totalValue = order.getOrderProducts().stream()
                .mapToDouble(op -> op.getQuantity() * op.getProduct().getPrice())
                .sum();
        order.setTotalValue(totalValue);

        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }
}
