package com.sda.repository;

import com.sda.model.Advert;
import com.sda.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
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
   
   
   public void drop() {
      adverts.clear();
   }
   
   public List<Advert> getFiltered(final Integer minMileage, final Integer maxMileage,
                                   final Integer minYear, final Integer maxYear,
                                   final Integer minPrice, final Integer maxPrice) {
      
      return adverts.parallelStream()
            .filter(ad -> ad.getCar().getMileage() >= minMileage
                  && ad.getCar().getMileage() <= maxMileage)
            .filter(ad -> ad.getCar().getYear() >= minYear
                  && ad.getCar().getYear() <= maxYear)
            .filter(ad -> ad.getPrice() >=minPrice
            && ad.getPrice() <= maxPrice)
            .collect(Collectors.toList());
   }
   
   public List<Advert> getFiltered(final String make,
                                   final Integer minMileage, final Integer maxMileage,
                                   final Integer minYear, final Integer maxYear,
                                   final Integer minPrice, final Integer maxPrice) {
      return getFiltered(minMileage, maxMileage,
            minYear, maxYear,
            minPrice, maxPrice).stream()
            .filter(ad->ad.getCar().getMake().equals(make))
            .collect(Collectors.toList());
   }
}
