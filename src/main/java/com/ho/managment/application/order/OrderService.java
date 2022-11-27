package com.ho.managment.application.order;

import com.ho.managment.domain.model.order.Order;
import com.ho.managment.portadapter.persistance.order.OrderConverter;
import com.ho.managment.portadapter.persistance.order.OrderJpaEntity;
import com.ho.managment.portadapter.persistance.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final OrderConverter orderConverter;

  public List<Order> getOrdersbyId(Integer clientId) {
    return orderRepository
        .findByClientId(clientId)
        .stream()
        .map(orderConverter::convert).collect(Collectors.toList());
  }

  public List<Order> getAllOrders() {
    return orderRepository
        .findAll()
        .stream()
        .map(orderConverter::convert)
        .collect(Collectors.toList());
  }

  public Order createOrder(Order order) {
    return orderConverter
        .convert(
            orderRepository
                .save(orderConverter.convert(order)));
  }

  public Order updateOrder(Order order) {
    OrderJpaEntity orderToUpdate = orderRepository.findById(order.getId()).orElseThrow(EntityNotFoundException::new);
    updateOrders(order, orderToUpdate);
    return orderConverter.convert(orderRepository.save(orderToUpdate));
  }

  private void updateOrders(Order order, OrderJpaEntity orderToUpdate) {
    orderToUpdate.setProducts(orderConverter.products(order));
    orderToUpdate.setTransportor(order.getTransportor());
    orderToUpdate.setDate(order.getDate());
    orderToUpdate.setAdvance(order.getAdvance());
    orderToUpdate.setPrice(orderToUpdate.getPrice());
    orderToUpdate.setFoire(orderToUpdate.getFoire());
  }

  public void deleteOrder(Integer orderId) {
    if (!orderRepository.existsById(orderId)) {
      throw new EntityNotFoundException("Invalid Id was provided");
    }
    orderRepository.deleteById(orderId);
  }
}
