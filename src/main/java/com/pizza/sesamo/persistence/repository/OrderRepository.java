package com.pizza.sesamo.persistence.repository;

import com.pizza.sesamo.persistence.entity.OrderEntity;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {

    List<OrderEntity> findAllByDateAfter(LocalDateTime date);
    List<OrderEntity> findAllByMethodIn(List<String> methods);
}
