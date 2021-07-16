package com.example.springjparelations.persistence.repository;

import com.example.springjparelations.persistence.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);
    List<Product> findAllByPrice(String price);
}
