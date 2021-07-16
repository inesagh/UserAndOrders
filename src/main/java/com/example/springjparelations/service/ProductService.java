package com.example.springjparelations.service;

import com.example.springjparelations.controller.productcontroller.model.ProductResponse;
import com.example.springjparelations.converter.ProductConverter;
import com.example.springjparelations.persistence.model.Product;
import com.example.springjparelations.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductConverter converter;

    public ProductService(ProductRepository repository, ProductConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public Product create(Product product){
        return repository.save(product);
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product getById(Long id){
        return repository.getById(id);
    }

    public List<Product> getByYourChoice(String term, String value){
        if(term.equals("name")){
            return repository.findAllByName(value);
        }else if(term.equals("price")){
            return repository.findAllByPrice(value);
        }else {
            return null;
        }
    }

    public Product update(Long id, Product product){
        Product byId = repository.getById(id);
        byId.setId(product.getId());
        byId.setName(product.getName());
        byId.setPrice(product.getPrice());
        Product updated = repository.save(byId);
        return updated;
    }

    public Boolean delete(Long id){
        repository.delete(repository.getById(id));
        return !repository.existsById(id);
    }
}
