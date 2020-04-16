package com.sda.controller;

import com.sda.filter.AdsQueryValidationFilter;
import com.sda.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@WebServlet(name = "AdvertListController", value = "/list")
public class AdvertListController extends HttpServlet {
   
   private static final AdvertService advertService = AdvertService.getInstance();
   
   @Override
   protected void doGet(final HttpServletRequest req,
                        final HttpServletResponse resp) throws ServletException, IOException {
      
      req.setAttribute("makeList", advertService.getAllMakes());
      
      
      if (req.getParameterMap().isEmpty()) {
         req.setAttribute("adsList", advertService.getAllAds());
      } else {
         final String make = (String) req.getAttribute("make");
         final int minPrice = (int) req.getAttribute("minPrice");
         final int maxPrice = (int) req.getAttribute("maxPrice");
         final int minYear = (int) req.getAttribute("minYear");
         final int maxYear = (int) req.getAttribute("maxYear");
         final int minMileage = (int) req.getAttribute("minMileage");
         final int maxMileage = (int) req.getAttribute("maxMileage");
         
         req.setAttribute("adsList", advertService.getFiltered(make,
               minMileage, maxMileage,
               minYear, maxYear,
               minPrice, maxPrice));
      }
      
      req.getRequestDispatcher("/list.jsp").forward(req, resp);
   }
   
}
