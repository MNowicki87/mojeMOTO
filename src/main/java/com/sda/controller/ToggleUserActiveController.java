package com.sda.controller;

import com.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToggleUserActiveController", value = "/admin/user/toggleUserActive")
public class ToggleUserActiveController extends HttpServlet {
   
   final UserService userService = UserService.getInstance();
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int userId = Integer.parseInt(request.getParameter("userId"));
      userService.toggleUserActive(userId);
   
      response.sendRedirect(request.getContextPath() + "/admin/users");
   }
}
