package com.sda.service;

import com.sda.model.Advert;
import com.sda.repository.AdvertRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AdvertService {
   
   private static AdvertService advertService;
   
   private AdvertRepository advertRepository;
   
   public static AdvertService getInstance(){
      if (advertService == null) {
         advertService = new AdvertService(AdvertRepository.anAdvertRepository());
      }
      return advertService;
   }
   
   public List<Advert> getAllAds() {
      return advertRepository.getAll();
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
}
