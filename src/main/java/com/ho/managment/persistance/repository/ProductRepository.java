package com.ho.managment.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ho.managment.persistance.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
