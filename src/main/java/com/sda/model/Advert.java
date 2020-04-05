package com.sda.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Advert {
   boolean isActive;
   LocalDateTime createdAt;
   int price;
   User owner;
   Car car;
}
