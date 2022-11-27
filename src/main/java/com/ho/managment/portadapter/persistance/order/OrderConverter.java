package com.ho.managment.portadapter.persistance.order;

import com.ho.managment.domain.model.order.Order;
import com.ho.managment.domain.model.product.Product;
import com.ho.managment.portadapter.persistance.client.ClientMapper;
import com.ho.managment.portadapter.persistance.product.ProductConverter;
import com.ho.managment.portadapter.persistance.product.ProductJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {

  private final ClientMapper clientMapper;
  private final ProductConverter productConverter;

  public Order convert(OrderJpaEntity orderJpaEntity) {
    return Order.builder()
        .id(orderJpaEntity.getId())
        .client(clientMapper.toDomain(orderJpaEntity.getClient()))
        .products(products(orderJpaEntity))
        .build();
  }

  public OrderJpaEntity convert(Order order){
    return OrderJpaEntity
        .builder()
        .id(order.getId())
        .client(clientMapper.toJpaEntity(order.getClient()))
        .products(products(order))
        .build();

  }

  public Set<Product> products(OrderJpaEntity orderJpaEntity){
    return orderJpaEntity
        .getProducts()
        .stream().
        map(productConverter::convert)
        .collect(Collectors.toSet());
  }

  public Set<ProductJpaEntity> products(Order order){
    return order
        .getProducts()
        .stream()
        .map(productConverter::convert)
        .collect(Collectors.toSet());
  }
}
