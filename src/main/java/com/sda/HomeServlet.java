package com.sda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
   
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("home.jsp");
      dispatcher.forward(httpServletRequest, httpServletResponse);
   
   }
}
