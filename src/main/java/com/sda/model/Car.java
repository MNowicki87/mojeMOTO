package com.sda.model;

import lombok.*;

@Data
@Builder
public class Car {
   String make;
   String model;
   int mileage;
   int year;
   String imageLink;
}
