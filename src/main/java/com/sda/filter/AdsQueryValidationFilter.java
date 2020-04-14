package com.sda.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@WebFilter("/list")
public class AdsQueryValidationFilter implements Filter {
   private static final String MAKE_DEFAULT = "any";
   private static final int MIN_PRICE_DEFAULT = 100;
   private static final int MAX_PRICE_DEFAULT = Integer.MAX_VALUE;
   private static final int MIN_YEAR_DEFAULT = 1900;
   private static final int MAX_YEAR_DEFAULT = LocalDateTime.now().getYear() + 1;
   private static final int MIN_MILEAGE_DEFAULT = 0;
   private static final int MAX_MILEAGE_DEFAULT = Integer.MAX_VALUE;
   
   public void destroy() {
   }
   
   public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
      
      final Map<String, String> parameterMap = req.getParameterMap().entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()[0]));
      
      final String make = Optional.ofNullable(parameterMap.get("make")).orElse(MAKE_DEFAULT);
      final int minPrice = validateParameter(Optional.ofNullable(parameterMap.get("minPrice")).orElse(""), MIN_PRICE_DEFAULT);
      final int maxPrice = validateParameter(Optional.ofNullable(parameterMap.get("maxPrice")).orElse(""), MAX_PRICE_DEFAULT);
      final int minYear = validateParameter(Optional.ofNullable(parameterMap.get("minYear")).orElse(""), MIN_YEAR_DEFAULT);
      final int maxYear = validateParameter(Optional.ofNullable(parameterMap.get("maxYear")).orElse(""), MAX_YEAR_DEFAULT);
      final int minMileage = validateParameter(Optional.ofNullable(parameterMap.get("minMileage")).orElse(""), MIN_MILEAGE_DEFAULT);
      final int maxMileage = validateParameter(Optional.ofNullable(parameterMap.get("maxMileage")).orElse(""), MAX_MILEAGE_DEFAULT);
      
      req.setAttribute("make", make);
      req.setAttribute("minPrice", minPrice);
      req.setAttribute("maxPrice", maxPrice);
      req.setAttribute("minYear", minYear);
      req.setAttribute("maxYear", maxYear);
      req.setAttribute("minMileage", minMileage);
      req.setAttribute("maxMileage", maxMileage);
      
      chain.doFilter(req, resp);
   }
   
   private int validateParameter(final String number, final int numDefault) {
      if (number.isBlank()) return numDefault;
      try {
         return Integer.parseInt(number);
      } catch (NumberFormatException e) {
         e.printStackTrace();
         return numDefault;
      }
   }
   
   public void init(FilterConfig config) throws ServletException {
   
   }
   
}
