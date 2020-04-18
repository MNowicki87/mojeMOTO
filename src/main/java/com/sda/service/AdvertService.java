package com.sda.service;

import com.sda.model.Advert;
import com.sda.repository.AdvertRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AdvertService {
   
   private static AdvertService advertService;
   
   private final AdvertRepository advertRepository;
   
   public static AdvertService getInstance() {
      if (advertService == null) {
         advertService = new AdvertService(AdvertRepository.anAdvertRepository());
      }
      return advertService;
   }
   
   public List<Advert> getAllAds() {
      return getPremiumAdsFirst(advertRepository.getAll());
   }
   
   private List<Advert> getPremiumAdsFirst(final List<Advert> adList) {
      final List<Advert> premiumFirstList = adList.stream()
            .filter(Advert::isPremium).collect(Collectors.toList());
      final List<Advert> standardList = adList.stream()
            .filter(ad -> !ad.isPremium()).collect(Collectors.toList());
      premiumFirstList.addAll(standardList);
      return premiumFirstList;
   }
   
   public List<String> getAllMakes() {
      return advertRepository.getAll().stream().map(ad -> ad.getCar().getMake()).sorted().collect(Collectors.toList());
   }
   
   public List<Advert> getAdsByUser(String login) {
      return advertRepository.getAdsByUser(login);
   }
   
   public boolean addListing(final Advert ad) {
      return advertRepository.addAdvert(ad);
   }
   
   public void depopulateData() {
      advertRepository.drop();
   }
   
   public List<Advert> getFiltered(final String make,
                                   final int minMileage, final int maxMileage,
                                   final int minYear, final int maxYear,
                                   final int minPrice, final int maxPrice) {
      List<Advert> filtered;
      if (!getAllMakes().contains(make)) {
         filtered = advertRepository.getFiltered(minMileage, maxMileage,
               minYear, maxYear,
               minPrice, maxPrice);
      } else {
         filtered = advertRepository.getFiltered(make,
               minMileage, maxMileage,
               minYear, maxYear,
               minPrice, maxPrice);
      }
      
      return getPremiumAdsFirst(filtered);
      
   }
   
}
