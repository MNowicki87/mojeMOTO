package com.sda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SimpleServlet", value = "simple")
public class SimpleServlet extends HttpServlet {
   
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("day1/simple.jsp");
      requestDispatcher.forward(httpServletRequest, httpServletResponse);
   }
   
}
