package com.sda.request;

import lombok.Value;

@Value
public class EditUserRequest {
   int id;
   String name;
   String surname;
//   String login;
}
