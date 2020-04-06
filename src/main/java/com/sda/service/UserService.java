package com.sda.service;

import com.sda.model.User;
import com.sda.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
   
   private static UserService userService;
   
   private UserRepository userRepository;
   
   public static UserService getInstance() {
      if(userService == null) {
         userService = new UserService(UserRepository.aUserRepository());
      }
      return userService;
   }
   
   public boolean registerUser(User user) {
      return userRepository.save(user);
   }
   
   public Optional<User> getUserByLogin(final String login, final String pwd) {
      return userRepository.findUserByEmailAndPassword(login, pwd);
   }
   
   public void depopulateData() {
      userRepository.depopulataData();
   }
}
