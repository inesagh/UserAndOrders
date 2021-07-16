package com.example.springjparelations.facade;

import com.example.springjparelations.controller.ordercontroller.model.OrderRequest;
import com.example.springjparelations.controller.ordercontroller.model.OrderResponse;
import com.example.springjparelations.converter.OrderConverter;
import com.example.springjparelations.persistence.model.Order;
import com.example.springjparelations.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacade {
    private final OrderService service;
    private final OrderConverter converter;

    public OrderFacade(OrderService service, OrderConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    public OrderResponse create(OrderRequest request){
        Order order = service.create(request);
        return converter.convertToResponse(order);
    }

    public List<OrderResponse> getAll(){
        List<Order> all = service.getAll();
        return converter.convertListToResponse(all);
    }

    public Boolean delete(Long id){
        return service.delete(id);
    }
}
