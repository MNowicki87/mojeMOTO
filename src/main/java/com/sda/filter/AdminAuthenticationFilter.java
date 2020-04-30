package com.sda.filter;

import com.sda.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "AdminAuthenticationFilter", value = "/admin/*")
public class AdminAuthenticationFilter implements Filter {
   public void destroy() {
   }
   
   
   public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
      
      HttpServletRequest request = (HttpServletRequest) req;
      HttpServletResponse response = (HttpServletResponse) resp;
      
      final Object user = request.getSession().getAttribute("user");
      
      if (user != null) {
         final User userObject = (User) user;
         final boolean isAdmin = userObject.isAdmin();
         if (isAdmin) {
            chain.doFilter(req, resp);
         }
      } else {
         System.out.println("Admin access privileges required! Redirecting");
         response.sendRedirect(request.getContextPath() + "/home");
      }
   }
   
   public void init(FilterConfig config) throws ServletException {
   
   }
   
}
