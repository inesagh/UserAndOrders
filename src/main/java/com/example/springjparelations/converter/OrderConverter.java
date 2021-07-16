package com.example.springjparelations.converter;

import com.example.springjparelations.controller.ordercontroller.model.OrderResponse;
import com.example.springjparelations.persistence.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverter {
    public OrderResponse convertToResponse(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setQuantity(order.getQuantity());
        orderResponse.setId(order.getId());
        orderResponse.setTrackingNumber(order.getTrackingNumber());
        orderResponse.setProducts(order.getProducts());
        orderResponse.setPerson(order.getPerson());
        return orderResponse;
    }

    public List<OrderResponse> convertListToResponse(List<Order> responseList){
        return responseList.stream().map(each -> convertToResponse(each))
                .collect(Collectors.toList());
    }
}
