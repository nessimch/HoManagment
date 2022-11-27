package com.ho.managment.controller.order;

import com.ho.managment.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<OrderDto> findOrders(){
        return orderService.findAll();
    }

    @PostMapping("")
    public OrderDto save(@RequestBody OrderDto orderDto){
        return orderService.save(orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        orderService.delete(id);
        return ResponseEntity
            .ok("Order with id: " + id + " was deleted successfully");
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody OrderDto orderDto) {
        orderService.update(orderDto);
        return ResponseEntity
            .ok("Order with id: " + orderDto.getId() + " was updated successfully");
    }
}
