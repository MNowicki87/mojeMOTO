package com.sda.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FilterAdsRequest {
   String make;
   int minMileage;
   int maxMileage;
   int minYear;
   int maxYear;
   int minPrice;
   int maxPrice;
}
