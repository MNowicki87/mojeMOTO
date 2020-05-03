package com.sda.service;

import com.sda.model.Advert;
import com.sda.repository.AdvertRepository;
import com.sda.request.FilterAdsRequest;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AdvertService {
   private static AdvertService advertService;
   private final AdvertRepository advertRepository;
   final UserService userService = UserService.getInstance();
   
   public static AdvertService getInstance() {
      if (advertService == null) {
         advertService = new AdvertService(AdvertRepository.anAdvertRepository());
      }
      return advertService;
   }
   
   public Map<Advert, String> getAllAds() {
      return getAdsMapWithUserName(getPremiumAdsFirst(advertRepository.getAll()));
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
   
   public List<Advert> getAdsByUser(int userId) {
      return advertRepository.getAdsByUser(userId);
   }
   
   public void addListing(final Advert ad) {
      advertRepository.addAdvert(ad);
   }
   
   public void depopulateData() {
      advertRepository.drop();
   }
   
   public Map<Advert, String> getFiltered(FilterAdsRequest req) {
      List<Advert> filtered;
      if (!getAllMakes().contains(req.getMake())) {
         filtered = advertRepository.getFiltered(req.getMinMileage(), req.getMaxMileage(),
               req.getMinYear(), req.getMaxYear(),
               req.getMinPrice(), req.getMaxPrice());
      } else {
         filtered = advertRepository.getFiltered(req.getMake(),
               req.getMinMileage(), req.getMaxMileage(),
               req.getMinYear(), req.getMaxYear(),
               req.getMinPrice(), req.getMaxPrice());
      }
      
      return getAdsMapWithUserName(filtered);

//      return getPremiumAdsFirst(filtered);
   }
   
   private Map<Advert, String> getAdsMapWithUserName(final List<Advert> filtered) {
      return filtered.stream()
            .collect(Collectors.toMap(advert -> advert, advert -> userService.getUserNameById(advert.getUserId())));
   }
   
}
