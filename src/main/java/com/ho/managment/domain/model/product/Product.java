package com.ho.managment.domain.model.product;

import com.ho.managment.domain.model.model.Model;
import com.ho.managment.portadapter.persistance.model.ModelJpaEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class Product {

  private Integer id;
  private String name;
  private Set<Model> models;
  private Integer quantity;
}
