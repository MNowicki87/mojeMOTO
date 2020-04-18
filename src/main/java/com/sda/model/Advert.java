package com.sda.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Advert {
   
   int price;
   User owner;
   Car car;
   LocalDateTime createdAt;
   boolean isActive;
   boolean isPremium;
   
}
