package com.sda.model;


import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class User {
   
   String name;
   String surname;
   String login;
   String password;
   
}
