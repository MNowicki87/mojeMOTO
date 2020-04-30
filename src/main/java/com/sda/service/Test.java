package com.sda.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
   public static void main(String[] args) {
      AtomicInteger ctr = new AtomicInteger(1);
      final List<String> strings = List.of(
            getDateString(3, 1, 31),
            getDateString(3, 1, 54),
            getDateString(3, 15, 45),
            getDateString(4, 23, 45),
            getDateString(6,4,39),
            getDateString(6,17, 39)
      );

      strings.forEach(date -> {
         System.out.println(ctr.getAndIncrement() + ": " + date);
      });
   
   }
   
   private static String getDateString(int days, int hours, int minutes) {
      return LocalDateTime.now()
            .minusDays(days)
            .minusHours(hours)
            .minusMinutes(minutes)
            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"));
   }
}
