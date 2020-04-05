package com.sda.day2;

import lombok.Data;
import lombok.Value;


@Value
public class Person {
   public String firstName;
   public String lastName;
   public String city;
   public int age;
   
}