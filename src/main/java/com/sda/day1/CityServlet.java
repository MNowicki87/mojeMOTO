package com.sda.day1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CityServlet", value = "/city")
public class CityServlet extends HttpServlet {
   
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("city.jsp");
      requestDispatcher.forward(httpServletRequest, httpServletResponse);
   }
   
   @Override
   protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      String city = httpServletRequest.getParameter("city");
      CityAdvisorService service = new CityAdvisorService();
      String club = service.getClubByCity(city);
      httpServletResponse.getWriter().print(club);
   }
}
