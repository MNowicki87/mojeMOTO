package com.sda;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Car {

  private String company;
  private String model;
  private Integer mileage;
  private Integer engine;
  private Integer year;
  private String country;

}
