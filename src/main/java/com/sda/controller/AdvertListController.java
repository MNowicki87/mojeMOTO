package com.sda.controller;

import com.sda.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdvertListController", value = "/list")
public class AdvertListController extends HttpServlet {
   
   private static AdvertService advertService = AdvertService.getInstance();
   
   @Override
   protected void doGet(final HttpServletRequest req,
                        final HttpServletResponse resp) throws ServletException, IOException {
      req.setAttribute("adsList", advertService.getAllAds());
      req.getRequestDispatcher("/list.jsp").forward(req, resp);
   }
}
