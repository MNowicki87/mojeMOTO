package com.sda.controller;

import com.sda.model.User;
import com.sda.request.EditUserRequest;
import com.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUserController", value = "/admin/user/editUser")
public class EditUserController extends HttpServlet {
   
   final UserService userService = UserService.getInstance();
   
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      Integer userId = Integer.valueOf(req.getParameter("userId"));
      User user = userService.getUserById(userId);
      
      req.setAttribute("user", user);
      
      req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
   }
   
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      final int id = Integer.parseInt(request.getParameter("id"));
      final String name = request.getParameter("name");
      final String surname = request.getParameter("surname");
   
      EditUserRequest editUserRequest = new EditUserRequest(id, name, surname);
      userService.editUser(editUserRequest);
      
      response.sendRedirect("/admin/users");
   }
   
   
}

