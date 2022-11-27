package com.ho.managment.domain.model.order;

import com.ho.managment.domain.model.client.Client;
import com.ho.managment.domain.model.product.Product;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
public class Order {
  private java.lang.Integer id;
  private Client client;
  private Set<Product> products = new HashSet<>();
  private String transportor;
  private LocalDateTime date;
  private double advance;
  private double price;
  private String foire;
}
