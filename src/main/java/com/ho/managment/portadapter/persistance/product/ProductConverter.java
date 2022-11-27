package com.ho.managment.portadapter.persistance.product;

import com.ho.managment.domain.model.model.Model;
import com.ho.managment.domain.model.product.Product;
import com.ho.managment.portadapter.persistance.model.ModelConverter;
import com.ho.managment.portadapter.persistance.model.ModelJpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductConverter {

  @Autowired
  private final ModelConverter modelConverter;

  public ProductConverter(@Lazy ModelConverter modelConverter) {
    this.modelConverter = modelConverter;
  }

  public Product convert(ProductJpaEntity productJpaEntity){
    return Product.builder()
        .id(productJpaEntity.getId())
        .name(productJpaEntity.getName())
        .models(models(productJpaEntity))
        .quantity(productJpaEntity.getQuantity())
        .build();
  }

  public ProductJpaEntity convert(Product product) {
    return ProductJpaEntity.builder()
        .id(product.getId())
        .name(product.getName())
        .models(models(product))
        .quantity(product.getQuantity())
        .build();
  }

  public Set<Model> models(ProductJpaEntity productJpaEntity){
    Set<ModelJpaEntity> models = productJpaEntity.getModels();
    return models
        .stream()
        .map(modelConverter::convert)
        .collect(Collectors.toSet());
  }

  public Set<ModelJpaEntity> models(Product product){
    return product
        .getModels()
        .stream()
        .map(modelConverter::convert)
        .collect(Collectors.toSet());
  }
}
