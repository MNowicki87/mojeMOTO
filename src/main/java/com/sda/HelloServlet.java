package com.sda;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet",
    value = "/home")
public class HelloServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("home.jsp");
    dispatcher.forward(httpServletRequest, httpServletResponse);
  }
}
