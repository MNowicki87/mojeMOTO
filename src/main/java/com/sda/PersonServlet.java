package com.sda;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PersonServlet", value = "/person")
public class PersonServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Person person = new Person("Rafal", "Kilanowski", 27, "łódź");
    req.setAttribute("person", person);
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("person.jsp");
    requestDispatcher.forward(req, resp);
  }
}
