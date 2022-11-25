package com.ho.managment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ho.managment.persistance.models.Order;
import com.ho.managment.persistance.repository.OrderRepository;

@Component
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
}
