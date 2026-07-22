package com.pizza.sesamo.persistence.repository;

import com.pizza.sesamo.persistence.entity.PizzaEntity;
import com.pizza.sesamo.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanOrderByPriceAsc(double price);
    int countByVeganTrue();

    @Query(value = """
        UPDATE pizza\s
        SET price = :#{#newPizzaPrice.newPrice}\s
        WHERE id_pizza = :#{#newPizzaPrice.pizzaId}
        """, nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newPizzaPrice")UpdatePizzaPriceDto newPizzaPrice);
}
