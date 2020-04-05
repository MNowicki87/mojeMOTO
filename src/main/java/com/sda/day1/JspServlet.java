package com.sda.day1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JspServlet", value = "day1/jsp")
public class JspServlet extends HttpServlet {
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("index.jsp");
      requestDispatcher.forward(httpServletRequest, httpServletResponse);
   }
}
