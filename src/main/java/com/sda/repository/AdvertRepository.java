package com.sda.repository;

import com.sda.model.Advert;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdvertRepository {
   
   private static AdvertRepository advertRepository;
   private List<Advert> adverts;
   
   public static AdvertRepository anAdvertRepository() {
      if (advertRepository == null) {
         advertRepository = new AdvertRepository(new ArrayList<>());
      }
      return advertRepository;
   }
   
   
}
