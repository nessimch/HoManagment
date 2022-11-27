package com.ho.managment.controller.order;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderDto {

  private Integer id;
  private Integer clientId;
  private String transportor;
  private double advance;
  private double price;
  private String foire;

}
