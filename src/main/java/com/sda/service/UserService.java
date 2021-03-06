package com.sda.service;

import com.sda.model.User;
import com.sda.repository.UserRepository;
import com.sda.request.EditUserRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
   
   private static UserService userService;
   
   private final UserRepository userRepository;
   
   public static UserService getInstance() {
      if(userService == null) {
         userService = new UserService(UserRepository.userRepository());
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
   
   public List<User> findAll() {
      return userRepository.findAll();
   }
   
   public User getUserById(int id) {
      return userRepository.getUserById(id);
   }
   
   public String getUserNameById(int id) {
      final User user = getUserById(id);
      return user.getName() + " " + user.getSurname();
   }
   
   public void editUser(EditUserRequest request) {
      User user = userRepository.getUserById(request.getId());
      user.setName(request.getName());
      user.setSurname(request.getSurname());
   }
   
   
   public void toggleUserActive(final int id) {
      userRepository.toggleActive(id);
   }
}
