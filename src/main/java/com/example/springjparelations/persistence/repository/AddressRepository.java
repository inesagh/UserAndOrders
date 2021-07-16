package com.example.springjparelations.persistence.repository;

import com.example.springjparelations.persistence.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
