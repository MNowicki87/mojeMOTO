package com.sda.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Car {
   String make;
   String model;
   int mileage;
   int year;
}
