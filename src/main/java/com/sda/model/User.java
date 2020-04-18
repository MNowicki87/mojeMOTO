package com.sda.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class User {
   
   int id;
   String name;
   String surname;
   String login;
   String password;
   List<Advert> observedAds;
   boolean isAdmin;
   boolean isActive;
   
}
