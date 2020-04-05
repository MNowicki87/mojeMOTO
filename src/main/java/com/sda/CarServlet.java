package com.sda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CarServlet", value = "/car")
public class CarServlet extends HttpServlet {
   
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest,
                        final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final HttpSession session = httpServletRequest.getSession();
      session.setAttribute("name", "Michal");
      final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("car.jsp");
      requestDispatcher.forward(httpServletRequest, httpServletResponse);
   }
   
   @Override
   protected void doPost(final HttpServletRequest httpServletRequest,
                         final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      Car car = Car.builder()
            .make(httpServletRequest.getParameter("make"))
            .model(httpServletRequest.getParameter("model"))
            .engine(httpServletRequest.getParameter("engine"))
            .country(httpServletRequest.getParameter("country"))
            .year(Integer.parseInt(httpServletRequest.getParameter("year")))
            .mileage(Integer.parseInt(httpServletRequest.getParameter("mileage")))
            .build();
      
      httpServletRequest.setAttribute("car", car);
   
      final RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("car-result.jsp");
      dispatcher.forward(httpServletRequest, httpServletResponse);
      
   }
}
