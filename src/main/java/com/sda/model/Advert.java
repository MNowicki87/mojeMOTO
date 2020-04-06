package com.sda.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Advert {
   boolean isActive;
   LocalDateTime createdAt;
   int price;
   User owner;
   Car car;
}
