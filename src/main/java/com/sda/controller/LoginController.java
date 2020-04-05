package com.sda.controller;

import com.sda.model.User;
import com.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
   
   private final UserService userService = UserService.aUserService();
   
   @Override
   protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("login.jsp").forward(req, resp);
   }
   
   @Override
   protected void doPost(final HttpServletRequest req,
                         final HttpServletResponse resp) throws ServletException, IOException {
      Optional<User> user = userService.getUserByLogin(req.getParameter("login"), req.getParameter("pwd"));
      boolean loggedInUser = user.isPresent();
      
      if (loggedInUser) {
         req.getSession().setAttribute("user", user.get());
         req.getRequestDispatcher("home.jsp").forward(req, resp);
      } else {
         req.getRequestDispatcher("register.jsp").forward(req, resp);
      }
      
      
      
   }
}
