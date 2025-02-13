package com.gabriel.demo.repositories;

import com.gabriel.demo.entities.OrderItem;
import com.gabriel.demo.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
