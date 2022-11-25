package com.ho.managment.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ho.managment.persistance.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
