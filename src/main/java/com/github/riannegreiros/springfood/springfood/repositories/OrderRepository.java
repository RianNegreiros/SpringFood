package com.github.riannegreiros.springfood.springfood.repositories;

import com.github.riannegreiros.springfood.springfood.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
