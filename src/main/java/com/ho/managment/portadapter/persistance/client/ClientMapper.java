package com.ho.managment.portadapter.persistance.client;

import com.ho.managment.domain.model.client.Client;
import com.ho.managment.domain.model.order.Order;
import com.ho.managment.portadapter.persistance.order.OrderConverter;
import com.ho.managment.portadapter.persistance.order.OrderJpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

  @Autowired
  private final OrderConverter orderConverter;

  public ClientMapper(@Lazy OrderConverter orderConverter) {
    this.orderConverter = orderConverter;
  }

  public Client toDomain(ClientJpaEntity clientJpaEntity) {
    return Client.builder()
        .id(clientJpaEntity.getId())
        .name(clientJpaEntity.getName())
        .mail(clientJpaEntity.getMail())
        .orders(orders(clientJpaEntity))
        .build();
  }

  public ClientJpaEntity toJpaEntity(Client client) {
    return
        ClientJpaEntity.builder()
            .id(client.getId())
            .name(client.getName())
            .mail(client.getMail())
            .orderJpaEntities(orders(client))
            .build();
  }

  public Set<Order> orders(ClientJpaEntity clientJpaEntity) {
    return clientJpaEntity
        .getOrderJpaEntities()
        .stream()
        .map(orderConverter::convert)
        .collect(Collectors.toSet());
  }

  public Set<OrderJpaEntity> orders(Client client) {
    return client
        .getOrders()
        .stream()
        .map(orderConverter::convert)
        .collect(Collectors.toSet());

  }

}
