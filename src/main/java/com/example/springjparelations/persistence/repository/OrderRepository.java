package com.example.springjparelations.persistence.repository;

import com.example.springjparelations.persistence.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
