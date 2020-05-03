package com.sda.controller;

import com.sda.request.FilterAdsRequest;
import com.sda.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ListAdvertsController", value = "/panel/list")
public class ListAdvertsController extends HttpServlet {
   
   private static final AdvertService advertService = AdvertService.getInstance();
   
   @Override
   protected void doGet(final HttpServletRequest req,
                        final HttpServletResponse resp) throws ServletException, IOException {
      
      req.setAttribute("makeList", advertService.getAllMakes());
      
      if (req.getParameterMap().isEmpty()) {
         req.setAttribute("adsMap", advertService.getAllAds());
      } else {
         final FilterAdsRequest filterAdsRequest = FilterAdsRequest.builder()
               .make((String) req.getAttribute("make"))
               .minPrice((int) req.getAttribute("minPrice"))
               .maxPrice((int) req.getAttribute("maxPrice"))
               .minYear((int) req.getAttribute("minYear"))
               .maxYear((int) req.getAttribute("maxYear"))
               .minMileage((int) req.getAttribute("minMileage"))
               .maxMileage((int) req.getAttribute("maxMileage"))
               .build();
         
         req.setAttribute("adsMap", advertService.getFiltered(filterAdsRequest));
      }
      
      req.getRequestDispatcher("/list.jsp").forward(req, resp);
   }
   
}
