package com.sda.repository;

import com.sda.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository {
   
   private static UserRepository userRepository;
   
   private List<User> users;
   
   public static UserRepository aUserRepository() {
      if (userRepository == null) {
         userRepository = new UserRepository(new ArrayList<>());
      }
      return userRepository;
   }
   
   public boolean save(User user) {
      Optional<User> existingUser = users.stream()
            .filter(u->u.getLogin().equals(user.getLogin()))
            .findAny();
      if (existingUser.isPresent()) {
         return false;
      }
      users.add(user);
      return true;
   }
   
   public Optional<User> findUserByEmailAndPassword(final String login, final String password) {
      return users.stream()
            .filter(u->u.getLogin().equals(login))
            .filter(u->u.getPassword().equals(password)).findFirst();
   }
   
   public void depopulataData() {
      users.clear();
   }
}

