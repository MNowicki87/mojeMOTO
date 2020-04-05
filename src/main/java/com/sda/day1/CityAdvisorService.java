package com.sda.day1;

public class CityAdvisorService {
   
   public String getClubByCity(String city) {
      if (city.equals("Warszawa")) {
         return "Legia Warszawa";
      } else if (city.equals("Lodz")) {
         return "Widzew Lodz";
      } else if (city.equals("Gdansk")) {
         return "Lechia Gdansk";
      } else if (city.equals("Chorzow")) {
         return "Ruch Chorzow";
      } else {
         return "Lechia Gdansk";
      }
   }
}


