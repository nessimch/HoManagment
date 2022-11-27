package com.ho.managment.portadapter.persistance.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ho.managment.portadapter.persistance.order.OrderJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderJpaEntity, Integer> {

  @Query("select o from OrderJpaEntity o where o.id = :clientId ")
  List<OrderJpaEntity> findByClientId(@Param("clientId") Integer clientId);
}
