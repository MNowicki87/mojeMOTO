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
   
   public static final String LOGIN_FAILED_MESSAGE = "Podano nieprawidłowe dane logowania";
   
   private final UserService userService = UserService.getInstance();
   
   @Override
   protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("/login.jsp").forward(req, resp);
   }
   
   @Override
   protected void doPost(final HttpServletRequest req,
                         final HttpServletResponse resp) throws ServletException, IOException {
      
      final String login = req.getParameter("login");
      final String pwd = req.getParameter("pwd");
      
      
      Optional<User> user = userService.getUserByLogin(login, pwd);
      boolean loggedInUser = user.isPresent();
      
      if (loggedInUser) {
         req.getSession().setAttribute("user", user.get());
         req.getSession().setAttribute("message", "Witaj " + user.get().getName() + "!");
         req.getRequestDispatcher("/home.jsp").forward(req, resp);
      } else {
         req.setAttribute("loginFailure", LOGIN_FAILED_MESSAGE);
         req.getRequestDispatcher("/login.jsp").forward(req, resp);
      }
//      resp.sendRedirect("/home.jsp");
      
      
   }
}
