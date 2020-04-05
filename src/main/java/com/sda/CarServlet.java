package com.sda;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CarServlet", value = "/car")
public class CarServlet extends HttpServlet {

  private static AtomicInteger counter = new AtomicInteger(1);


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.setAttribute("name", "Rafal " + counter.getAndIncrement());

    RequestDispatcher dispatcher = req.getRequestDispatcher("car.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Car car = Car.builder()
        .company(req.getParameter("company"))
        .country(req.getParameter("country"))
        .engine(Integer.valueOf(req.getParameter("engine")))
        .mileage(Integer.valueOf(req.getParameter("mileage")))
        .model(req.getParameter("model"))
        .year(Integer.valueOf(req.getParameter("year")))
        .build();

    req.setAttribute("car", car);

    RequestDispatcher dispatcher = req.getRequestDispatcher("car-result.jsp");
    dispatcher.forward(req, resp);
  }
}
