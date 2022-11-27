package com.ho.managment.domain.model.client;

import com.ho.managment.domain.model.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@Data
public class Client {
  @Getter Integer id;
  @Getter String name;
  @Getter String mail;
  @Getter Set<Order> orders = new HashSet<>();
}
