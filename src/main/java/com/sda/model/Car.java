package com.sda.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
   String make;
   String model;
   int mileage;
   int year;
   String imageLink;
}
