package com.sda.controller;

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
   
   private static final String MAKE_INIT_VALUE = "any";
   private static final int currentYear = LocalDateTime.now().getYear();
   private static final AdvertService advertService = AdvertService.getInstance();
   
   @Override
   protected void doGet(final HttpServletRequest req,
                        final HttpServletResponse resp) throws ServletException, IOException {
      
      req.setAttribute("makeList", advertService.getAllMakes());
      
      
      if (req.getParameterMap().isEmpty()) {
         req.setAttribute("adsList", advertService.getAllAds());
      } else {
         
         final Map<String, String> parameterMap = req.getParameterMap().entrySet().stream()
               .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()[0]));
         
         parameterMap.entrySet().forEach(entry -> {
            if (entry.getValue().isBlank()) {
               if (entry.getKey().equals("make")) {
                  entry.setValue(MAKE_INIT_VALUE);
               } else {
                  entry.setValue("0");
               }
            }
         });
         
         final String make = Optional.ofNullable(parameterMap.get("make")).orElse(MAKE_INIT_VALUE);
         final int minMileage = Integer.parseInt(parameterMap.get("mileage-from"));
         final int maxMileage = Integer.parseInt(parameterMap.get("mileage-to"));
         final int minYear = Integer.parseInt(parameterMap.get("year-from"));
         final int maxYear = Integer.parseInt(parameterMap.get("year-to"));
         final int minPrice = Integer.parseInt(parameterMap.get("price-from"));
         final int maxPrice = Integer.parseInt(parameterMap.get("price-to"));
         
         req.setAttribute("adsList", advertService.getFiltered(make,
               minMileage, maxMileage,
               minYear, maxYear,
               minPrice, maxPrice));
      }
      req.getRequestDispatcher("/list.jsp").forward(req, resp);
   }
   
}
