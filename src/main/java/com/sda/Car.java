package com.sda;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Car {
   String make;
   String model;
   String country;
   String engine;
   int year;
   int mileage;
   
}
