package com.sda.controller;

import com.sda.model.Advert;
import com.sda.model.User;
import com.sda.service.AdvertService;
import com.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ObervedAdsController", value = "/panel/observed")
public class ObervedAdsController extends HttpServlet {
   private final AdvertService advertService = AdvertService.getInstance();
   private final UserService userService = UserService.getInstance();
   
//   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      final User user = (User) request.getSession().getAttribute("user");
      
      
      final Map<Advert, String> adsMap = advertService.getAdsObservedByUser(user.getId());
      request.setAttribute("adsMap", adsMap);
   
      request.getRequestDispatcher("/list.jsp").forward(request, response);
   }
}
