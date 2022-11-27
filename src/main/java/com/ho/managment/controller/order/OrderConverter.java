package com.ho.managment.controller.order;

import com.ho.managment.persistance.models.Client;
import com.ho.managment.persistance.models.Order;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class OrderConverter {

  public OrderDto convert(Order order){
    return OrderDto
        .builder()
        .id(order.getId())
        .clientId(order.getClient().getId())
        .transportor(order.getTransportor())
        .advance(order.getAdvance())
        .price(order.getPrice())
        .foire(order.getFoire())
        .build();
  }

  public Order convert(OrderDto order, Client client){
    return Order
        .builder()
        .id(order.getId())
        .client(client)
        .transportor(order.getTransportor())
        .advance(order.getAdvance())
        .price(order.getPrice())
        .foire(order.getFoire())
        .build();
  }
}
