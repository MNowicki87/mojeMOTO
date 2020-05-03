package com.sda.repository;

import com.sda.model.User;
import com.sda.model.UserRole;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository {
   
   public static final String USR1 = "usr1";
   public static final String USR2 = "usr2";
   public static final String PWD = "pwd";
   
   private static final AtomicInteger counter = new AtomicInteger(1);
   
   private static UserRepository userRepository;
   
   private final List<User> users;
   
   public static UserRepository userRepository() {
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
      user.setId(counter.getAndIncrement());
      users.add(user);
      return true;
   }
   
   public Optional<User> findUserByEmailAndPassword(final String login, final String password) {
      return users.stream()
            .filter(u->u.getLogin().equalsIgnoreCase(login))
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
            .email("nowicki.pl@gmail.com")
            .userRole(UserRole.USER)
            .isActive(true)
            .build();
      
      final User jkow = User.builder()
            .name("Jan")
            .surname("Kowalski")
            .login(USR2)
            .password(PWD)
            .userRole(UserRole.USER)
            .isActive(true)
            .build();
   
      final User admin = User.builder()
            .name("admin")
            .surname("admin")
            .login("admin")
            .password("admin")
            .email("nowicki.pl@gmail.com")
            .userRole(UserRole.ADMIN)
            .isActive(true)
            .build();
   
      admin.setId(counter.getAndIncrement());
      mnow.setId(counter.getAndIncrement());
      jkow.setId(counter.getAndIncrement());
      
      userRepository().users.add(admin);
      userRepository().users.add(mnow);
      userRepository().users.add(jkow);
      
      userRepository().users.sort(Comparator.comparingInt(User::getId));
      
   }
   
   public List<User> findAll() {
      return List.copyOf(users);
   }
   
   public User getUserById(final int id) {
      return users.stream()
            .filter(usr-> usr.getId() == id)
            .findFirst()
            .get();
   }
   
   public void toggleActive(final int id) {
      final User user = getUserById(id);
      user.setActive(!user.isActive());
   }
}

