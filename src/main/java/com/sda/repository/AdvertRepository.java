package com.sda.repository;

import com.sda.model.Advert;
import com.sda.model.Car;
import com.sda.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdvertRepository {
   
   private static AdvertRepository advertRepository;
   private final List<Advert> adverts;
   
   public static AdvertRepository anAdvertRepository() {
      if (advertRepository == null) {
         advertRepository = new AdvertRepository(new ArrayList<>());
         addListings();
      }
      return advertRepository;
   }
   
   private static void addListings() {
      final String USR1 = "usr1";
      final String USR2 = "usr2";
      final String PWD = "pwd";
      
      final UserService userService = UserService.getInstance();
      final Car mazda = Car.builder()
            .make("Mazda")
            .model("323")
            .year(1996)
            .mileage(233222)
            .imageLink("https://www.autoscout24.pl/assets/auto/images/model/mazda/mazda-323/mazda-323-l-01.webp")
            .build();
      final Advert ad1 = Advert.builder()
            .car(mazda)
            .createdAt(LocalDateTime.now())
            .isActive(true)
            .owner(userService.getUserByLogin(USR1, PWD).orElseThrow())
            .price(3200)
            .build();
      advertRepository.addAdvert(ad1);
      
      final Car merc = Car.builder()
            .make("Mercedes-Benz")
            .model("190E")
            .year(1987)
            .mileage(900000)
            .imageLink("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Mercedes-Benz_W201_front_20081128.jpg/800px-Mercedes-Benz_W201_front_20081128.jpg")
            .build();
      final Advert ad2 = Advert.builder()
            .car(merc)
            .createdAt(LocalDateTime.now())
            .isActive(true)
            .owner(userService.getUserByLogin(USR2, PWD).orElseThrow())
            .price(22900)
            .build();
      advertRepository.addAdvert(ad2);
      
      final Car bimmer = Car.builder()
            .make("BMW")
            .model("M3")
            .year(2009)
            .mileage(90000)
            .imageLink("https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/BMW_E92_M3_Coup%C3%A9_1.JPG/800px-BMW_E92_M3_Coup%C3%A9_1.JPG")
            .build();
      final Advert ad3 = Advert.builder()
            .car(bimmer)
            .createdAt(LocalDateTime.now())
            .isActive(true)
            .owner(userService.getUserByLogin(USR2, PWD).get())
            .price(60000)
            .build();
      advertRepository.addAdvert(ad3);
      
      final Car audi = Car.builder()
            .make("Audi")
            .model("S4")
            .year(1992)
            .mileage(312900)
            .imageLink("https://3de571wk9zn6ej6t1z5tb714-wpengine.netdna-ssl.com/wp-content/uploads/2018/01/00H0H_4vCflzKOFWU_1200x900.jpg")
            .build();
      final Advert ad4 = Advert.builder()
            .car(audi)
            .createdAt(LocalDateTime.now())
            .isActive(true)
            .owner(userService.getUserByLogin(USR1, PWD).get())
            .price(28900)
            .isPremium(true)
            .build();
      advertRepository.addAdvert(ad4);
      
      final Car volvo = Car.builder()
            .make("Volvo")
            .model("V90")
            .year(2019)
            .mileage(24000)
            .imageLink("https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/2016_Volvo_V90_Inscription_D5_PP_AWD_2.0_Front.jpg/800px-2016_Volvo_V90_Inscription_D5_PP_AWD_2.0_Front.jpg")
            .build();
      final Advert ad5 = Advert.builder()
            .car(volvo)
            .createdAt(LocalDateTime.now())
            .isActive(true)
            .owner(userService.getUserByLogin(USR2, PWD).get())
            .price(230000)
            .build();
      advertRepository.addAdvert(ad5);
      
      final Car seggy = Car.builder()
            .make("Koenigsegg")
            .model("One:1")
            .year(2015)
            .mileage(3900)
            .imageLink("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Koenigsegg_One-1_-_Gen%C3%A8ve_2014_-_01.jpg/800px-Koenigsegg_One-1_-_Gen%C3%A8ve_2014_-_01.jpg")
            .build();
      final Advert ad6 = Advert.builder()
            .car(seggy)
            .createdAt(LocalDateTime.now())
            .isActive(true)
            .owner(userService.getUserByLogin(USR1, PWD).get())
            .price(18_000_000)
            .isPremium(true)
            .build();
      advertRepository.addAdvert(ad6);
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
            .filter(ad -> ad.getPrice() >= minPrice
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
            .filter(ad -> ad.getCar().getMake().equals(make))
            .collect(Collectors.toList());
   }
   
}
