package com.ho.managment.portadapter.persistance.model;

import com.ho.managment.domain.model.model.Model;
import com.ho.managment.portadapter.persistance.product.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ModelConverter {

  @Autowired
  private final ProductConverter productConverter;

  public ModelConverter(@Lazy ProductConverter productConverter) {
    this.productConverter = productConverter;
  }

  public Model convert(ModelJpaEntity modelJpaEntity){
    return Model.builder()
        .id(modelJpaEntity.getId())
        .name(modelJpaEntity.getName())
        .sellingPrice(modelJpaEntity.getSellingPrice())
        .purchasePrice(modelJpaEntity.getPurchasePrice())
        .product(productConverter.convert(modelJpaEntity.getProduct()))
        .build();
  }

  public ModelJpaEntity convert(Model model){
    return ModelJpaEntity.builder()
        .id(model.getId())
        .name(model.getName())
        .sellingPrice(model.getSellingPrice())
        .purchasePrice(model.getPurchasePrice())
        .product(productConverter.convert(model.getProduct()))
        .build();
  }
}
