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

@WebServlet(name = "AdvertAddController", value = "/add")
public class AdvertAddController extends HttpServlet {
   
   private static AdvertService advertService = AdvertService.getInstance();
   private static UserService userService = UserService.getInstance();
   
   
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest,
                        final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      httpServletRequest.getRequestDispatcher("/add.jsp").forward(httpServletRequest, httpServletResponse);
   }
   
   @Override
   protected void doPost(final HttpServletRequest req,
                         final HttpServletResponse resp) throws ServletException, IOException {
      Advert advert = buildAd(req);
      advertService.addListing(advert);
      req.getRequestDispatcher("list.jsp").forward(req, resp);
   }
   
   private Advert buildAd(final HttpServletRequest req) {
      return Advert.builder()
            .car(buildCar(req))
            .price(Integer.parseInt(req.getParameter("price")))
            .createdAt(LocalDateTime.now())
            .isActive(true)
            .owner((User) req.getSession().getAttribute("user"))
            .build();
   }
   
   private Car buildCar(final HttpServletRequest req) {
      return Car.builder()
            .make(req.getParameter("make"))
            .model(req.getParameter("model"))
            .mileage(Integer.parseInt(req.getParameter("mileage")))
            .year(Integer.parseInt(req.getParameter("year")))
            .imageLink(req.getParameter("image-link"))
            .build();
   }
}
