package com.ho.managment.portadapter.web.order;

import com.ho.managment.application.order.OrderService;
import com.ho.managment.domain.model.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping("")
  public ResponseEntity<List<Order>> getOrdersByClient(@PathVariable Integer clientId){
    return ResponseEntity.ok(orderService.getOrdersbyId(clientId));
  }

  @PostMapping("")
  public ResponseEntity<Order> saveOrder(@RequestBody Order order){
    return ResponseEntity.status(HttpStatus.CREATED).body(
        orderService.createOrder(order)
    );
  }
}
