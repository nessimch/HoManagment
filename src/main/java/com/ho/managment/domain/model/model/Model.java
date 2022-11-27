package com.ho.managment.domain.model.model;

import com.ho.managment.domain.model.product.Product;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Model {
  private Integer id;
  private String name;
  private double sellingPrice;
  private double purchasePrice;
  private Product product;
}
