package com.sda.controller;

import com.sda.model.Advert;
import com.sda.model.Car;
import com.sda.model.User;
import com.sda.service.AdvertService;
import com.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "SetUpController", value = "/setup")
public class SetUpController extends HttpServlet {
   
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      setUp();
      httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest, httpServletResponse);
   }
   
   private final UserService userService = UserService.getInstance();
   private final AdvertService advertService = AdvertService.getInstance();
   
   private void setUp() {
      populateUsers();
      addListings();
   }
   
   private void addListings() {
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
            .owner(userService.getUserByLogin("mnow", "asdf").get())
            .price(3200)
            .build();
      advertService.addListing(ad1);
   
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
            .owner(userService.getUserByLogin("jkow", "asdf").get())
            .price(22900)
            .build();
      advertService.addListing(ad2);
      
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
            .owner(userService.getUserByLogin("jkow", "asdf").get())
            .price(60000)
            .build();
      advertService.addListing(ad3);
   
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
            .owner(userService.getUserByLogin("mnow", "asdf").get())
            .price(28900)
            .build();
      advertService.addListing(ad4);
      
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
            .owner(userService.getUserByLogin("jkow", "asdf").get())
            .price(230000)
            .build();
      advertService.addListing(ad5);
   
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
            .owner(userService.getUserByLogin("mnow", "asdf").get())
            .price(18_000_000)
            .build();
      advertService.addListing(ad6);
   }
   
   private void populateUsers() {
      final User mnow = User.builder()
            .name("Michał")
            .surname("Nowicki")
            .login("mnow")
            .password("asdf")
            .build();
   
      final User jkow = User.builder()
            .name("Jan")
            .surname("Kowalski")
            .login("jkow")
            .password("asdf")
            .build();
      
      userService.registerUser(mnow);
      userService.registerUser(jkow);
   }
}
