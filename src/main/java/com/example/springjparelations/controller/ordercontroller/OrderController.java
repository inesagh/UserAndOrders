package com.example.springjparelations.controller.ordercontroller;

import com.example.springjparelations.controller.ordercontroller.model.OrderRequest;
import com.example.springjparelations.controller.ordercontroller.model.OrderResponse;
import com.example.springjparelations.facade.OrderFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderFacade facade;

    public OrderController(OrderFacade facade) {
        this.facade = facade;
    }

    @PostMapping("order")
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest order){
        OrderResponse response = facade.create(order);
        return ResponseEntity.ok(response);
    }

    @GetMapping("order")
    public ResponseEntity<List<OrderResponse>> getAll(){
        return ResponseEntity.ok(facade.getAll());
    }

    @DeleteMapping("order/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(facade.delete(id));
    }

}
