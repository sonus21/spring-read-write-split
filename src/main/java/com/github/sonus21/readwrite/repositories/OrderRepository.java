package com.github.sonus21.readwrite.repositories;

import com.github.sonus21.readwrite.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
