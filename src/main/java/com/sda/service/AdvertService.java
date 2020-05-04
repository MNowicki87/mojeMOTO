package com.sda.service;

import com.sda.model.Advert;
import com.sda.repository.AdvertRepository;
import com.sda.request.FilterAdsRequest;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AdvertService {
   private static AdvertService advertService;
   final UserService userService = UserService.getInstance();
   private final AdvertRepository advertRepository;
   
   public static AdvertService getInstance() {
      if (advertService == null) {
         advertService = new AdvertService(AdvertRepository.anAdvertRepository());
      }
      return advertService;
   }
   
   public Map<Advert, String> getAllAds() {
      return getPremiumAdsFirst(advertRepository.getAll());
   }
   
   private LinkedHashMap<Advert, String> getPremiumAdsFirst(final List<Advert> adList) {
      Comparator<Advert> sort = Comparator.comparing(Advert::isPremium).reversed();
      final LinkedHashMap<Advert, String> adsMap = new LinkedHashMap<>(getAdsMapWithUserName(adList));
      return adsMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey(sort))
            .collect(Collectors.toMap(
                  Map.Entry::getKey,
                  Map.Entry::getValue,
                  (oldV, newV) -> oldV,
                  LinkedHashMap::new));
   }
   
   private Map<Advert, String> getAdsMapWithUserName(final List<Advert> filtered) {
      return filtered.stream()
            .collect(Collectors.toMap(advert -> advert,
                  advert -> userService.getUserNameById(advert.getUserId())));
   }
   
   public List<String> getAllMakes() {
      return advertRepository.getAll().stream().map(ad -> ad.getCar().getMake()).sorted().collect(Collectors.toList());
   }
   
   public Map<Advert, String> getAdsByUser(int userId) {
      return getAdsMapWithUserName(
            advertRepository.getAdsByUser(userId));
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
      
      return getPremiumAdsFirst(filtered);

//      return getPremiumAdsFirst(filtered);
   }
   
}
