package com.sda.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Advert {
   
   int id;
   int price;
   int userId;
   Car car;
   LocalDateTime createdAt;
   boolean isActive;
   boolean isPremium;
   @Singular(ignoreNullCollections = true)
   Set<Integer> observersIds;
   
   
   
}
