package com.ho.managment.controller.client;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ClientDto {
  private Integer id;
  private String name;
  private String mail;
}
