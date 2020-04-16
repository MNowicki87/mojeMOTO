package com.sda.controller;

import com.sda.model.User;
import com.sda.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
   
   private UserService userService = UserService.getInstance();
   
   @Override
   protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
      final RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
      dispatcher.forward(req, resp);
   }
   
   
   @Override
   protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      
      User user = createUserFromForm(httpServletRequest);
      boolean created = userService.registerUser(user);
      if (created) {
         httpServletRequest.getRequestDispatcher("login.jsp")
               .forward(httpServletRequest, httpServletResponse);
      } else {
         httpServletRequest.setAttribute("loginExists", user.getLogin());
         httpServletRequest.getRequestDispatcher("register.jsp")
               .forward(httpServletRequest, httpServletResponse);
      }
   }
   
   private User createUserFromForm(final HttpServletRequest req) {
      return User.builder()
            .login(req.getParameter("login"))
            .name(req.getParameter("name"))
            .surname(req.getParameter("surname"))
            .password(req.getParameter("pwd"))
            .build();
   }
}
