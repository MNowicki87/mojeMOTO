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
      
      final String make = parameterMap.get("make");
      final int minPrice = validateParam(Optional.ofNullable(parameterMap.get("minPrice")).orElse(""), MIN_PRICE_DEFAULT);
      final int maxPrice = validateParam(Optional.ofNullable(parameterMap.get("maxPrice")).orElse(""), MAX_PRICE_DEFAULT);
      final int minYear = validateParam(Optional.ofNullable(parameterMap.get("minYear")).orElse(""), MIN_YEAR_DEFAULT);
      final int maxYear = validateParam(Optional.ofNullable(parameterMap.get("maxYear")).orElse(""), MAX_YEAR_DEFAULT);
      final int minMileage = validateParam(Optional.ofNullable(parameterMap.get("minMileage")).orElse(""), MIN_MILEAGE_DEFAULT);
      final int maxMileage = validateParam(Optional.ofNullable(parameterMap.get("maxMileage")).orElse(""), MAX_MILEAGE_DEFAULT);
      
      req.setAttribute("make", make);
      
      validateAndSetAttrPair("Price", minPrice, maxPrice, MIN_PRICE_DEFAULT, MAX_PRICE_DEFAULT, req, resp);
      validateAndSetAttrPair("Year", minYear, maxYear, MIN_YEAR_DEFAULT, MAX_YEAR_DEFAULT, req, resp);
      validateAndSetAttrPair("Mileage", minMileage, maxMileage, MIN_MILEAGE_DEFAULT, MAX_MILEAGE_DEFAULT, req, resp);
      
      chain.doFilter(req, resp);
   }
   
   private void validateAndSetAttrPair(final String paramName, int min, int max,
                                       final int minDefault, final int maxDefault,
                                       final ServletRequest req, final ServletResponse resp) throws ServletException, IOException {
      
      if (min >= max || min < minDefault || max > maxDefault) {
         min = minDefault;
         max = maxDefault;
         switch (paramName) {
            case "Price":
               req.setAttribute("invalid"+paramName+"Param", "Nieprawidłowy zakres cen! Kryteria zingorowane.");
               break;
            case "Year":
               req.setAttribute("invalid"+paramName+"Param", "Nieprawidłowe lata produkcji! Kryteria zingorowane.");
               break;
            case "Mileage":
               req.setAttribute("invalid"+paramName+"Param", "Nieprawidłowy zakres przebiegu! Kryteria zingorowane.");
         }
      }
      
      req.setAttribute("min" + paramName, min);
      req.setAttribute("max" + paramName, max);
      
   }
   
   private int validateParam(final String number, final int numDefault) {
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
