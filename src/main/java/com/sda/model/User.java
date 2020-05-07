package com.sda.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class User {
   
   int id;
   String name;
   String surname;
   String login;
   String password;
   String email;
   UserRole userRole;
   boolean isActive;
   
}
