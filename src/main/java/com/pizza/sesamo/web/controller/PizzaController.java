package com.pizza.sesamo.web.controller;

import com.pizza.sesamo.persistence.entity.PizzaEntity;
import com.pizza.sesamo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll() {
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> get(@PathVariable int idPizza) {
        return ResponseEntity.ok(this.pizzaService.get(idPizza));
    }

    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getAvailable() {
        return ResponseEntity.ok(this.pizzaService.getAvailable());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> get(@PathVariable String name) {
        return ResponseEntity.ok(this.pizzaService.getByName(name));
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizzaEntity) {
        if (pizzaEntity.getIdPizza() == null || !this.pizzaService.exists(pizzaEntity.getIdPizza())) {
//            return ResponseEntity.badRequest().build();
            return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));
        }
//        return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizzaEntity) {
        if (pizzaEntity.getIdPizza() == null || this.pizzaService.exists(pizzaEntity.getIdPizza())) {
//            return ResponseEntity.badRequest().build();
            return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));
        }

        return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void>  delete(@PathVariable int idPizza) {
        if (this.pizzaService.exists(idPizza)) {
            this.pizzaService.delete(idPizza);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
