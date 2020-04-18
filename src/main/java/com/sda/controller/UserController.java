package com.sda.controller;

import com.sda.model.User;
import com.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", value = "/admin/users")
public class UserController extends HttpServlet {
   
   final UserService userService = UserService.getInstance();
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      final List<User> users = userService.findAll();
      
      request.setAttribute("users", users);
      request.getRequestDispatcher("/users.jsp").forward(request, response);
      
   }
   
}
