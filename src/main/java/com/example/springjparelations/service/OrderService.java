package com.example.springjparelations.service;

import com.example.springjparelations.controller.ordercontroller.model.OrderRequest;
import com.example.springjparelations.persistence.model.Order;
import com.example.springjparelations.persistence.model.Person;
import com.example.springjparelations.persistence.model.Product;
import com.example.springjparelations.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final PersonService personService;
    private final ProductService productService;
    private final OrderRepository repository;

    public OrderService(PersonService personService, ProductService productService, OrderRepository repository) {
        this.personService = personService;
        this.productService = productService;
        this.repository = repository;
    }

    public Order create(OrderRequest request){
        Order order = buildOrder(request);
        return repository.save(order);
    }

    public List<Order> getAll(){
        return repository.findAll();
    }

    public Boolean delete(Long id){
        repository.delete(repository.getById(id));
        return !repository.existsById(id);
    }

    public Order buildOrder(OrderRequest request){
        Order order = new Order();
        Person person = personService.getById(request.getPersonId());
        order.setPerson(person);

        List<Product> products = order.getProducts();
        products.add(productService.getById(request.getProductId()));
        order.setProducts(products);

        String trackingNumber = UUID.randomUUID().toString().replace("-", "");
        order.setTrackingNumber(trackingNumber);

        order.setQuantity(request.getQuantity());
        return order;
    }
}
