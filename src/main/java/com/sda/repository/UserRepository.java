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
   
   public static final String USR1 = "usr1";
   public static final String USR2 = "usr2";
   public static final String PWD = "pwd";
   
   
   private static UserRepository userRepository;
   
   private final List<User> users;
   
   public static UserRepository aUserRepository() {
      if (userRepository == null) {
         userRepository = new UserRepository(new ArrayList<>());
         populateUsers();
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
   
   private static void populateUsers() {
      final String USR1 = "usr1";
      final String USR2 = "usr2";
      final String PWD = "pwd";
      
      final User mnow = User.builder()
            .name("Michał")
            .surname("Nowicki")
            .login(USR1)
            .password(PWD)
            .build();
      
      final User jkow = User.builder()
            .name("Jan")
            .surname("Kowalski")
            .login(USR2)
            .password(PWD)
            .build();
      
      aUserRepository().users.add(mnow);
      aUserRepository().users.add(jkow);
   }
   
   
}

