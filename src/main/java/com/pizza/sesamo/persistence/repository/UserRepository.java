package com.pizza.sesamo.persistence.repository;

import com.pizza.sesamo.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
