package com.ho.managment.controller.product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {
  private Integer productId;
  private String productName;
  private Integer quantity;
}
