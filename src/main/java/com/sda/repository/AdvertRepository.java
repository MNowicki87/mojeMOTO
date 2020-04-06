package com.sda.repository;

import com.sda.model.Advert;
import com.sda.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
   
   
   public List<Advert> getAll() {
      return List.copyOf(adverts);
   }
   
   public List<Advert> getAdsByUser(String userLogin) {
      return adverts.stream()
            .filter(advert ->
                  advert.getOwner().getLogin().equals(userLogin))
            .collect(Collectors.toList());
   }
   
   public boolean addAdvert(Advert advert) {
      return adverts.add(advert);
   }
   
   
}
