package com.example.springjparelations.facade;

import com.example.springjparelations.annotation.Facade;
import com.example.springjparelations.controller.productcontroller.model.ProductRequest;
import com.example.springjparelations.controller.productcontroller.model.ProductResponse;
import com.example.springjparelations.converter.ProductConverter;
import com.example.springjparelations.persistence.model.Product;
import com.example.springjparelations.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Facade
public class ProductFacade {
    private final ProductService service;
    private final ProductConverter converter;

    public ProductFacade(ProductService service, ProductConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    public ProductResponse create(ProductRequest request){
        Product product = converter.convertToEntity(request);
        return converter.convertToResponse(service.create(product));
    }

    public List<ProductResponse> getAll(){
        return converter.convertListToResponse(service.getAll());
    }

    public ProductResponse getById(Long id){
        return converter.convertToResponse(service.getById(id));
    }

    public List<ProductResponse> getByYourChoice(String term, String value){
        return converter.convertListToResponse(service.getByYourChoice(term, value));
    }

    public ProductResponse update(Long id, ProductRequest request){
        Product product = converter.convertToEntity(request);
        return converter.convertToResponse(service.update(id, product));
    }

    public Boolean delete(Long id){
        return service.delete(id);
    }
}
