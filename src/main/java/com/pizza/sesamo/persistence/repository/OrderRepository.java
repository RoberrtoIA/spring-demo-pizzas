package com.pizza.sesamo.persistence.repository;

import com.pizza.sesamo.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
}
