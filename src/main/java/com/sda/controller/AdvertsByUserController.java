package com.sda.controller;

import com.sda.model.User;
import com.sda.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdvertsByUserController", value = "/myads")
public class AdvertsByUserController extends HttpServlet {
   private static AdvertService advertService = AdvertService.getInstance();
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      User user = (User) httpServletRequest.getSession().getAttribute("user");
      httpServletRequest.setAttribute("adsList", advertService.getAdsByUser(user.getLogin()));
      httpServletRequest.getRequestDispatcher("list.jsp").forward(httpServletRequest, httpServletResponse);
   }
   
}