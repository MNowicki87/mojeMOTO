package com.sda.filter;

import com.sda.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ActiveAccountFilter", value = "/panel/add")
public class ActiveAccountFilter implements Filter {
   public void destroy() {
   }
   
   public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
      
      final HttpServletRequest request = (HttpServletRequest) req;
      final HttpServletResponse response = (HttpServletResponse) resp;
      final User user = (User) request.getSession().getAttribute("user");
      
      if (user.isActive()) {
         chain.doFilter(req, resp);
      } else {
         request.getSession().setAttribute("message", "Nie możesz dodać ogłoszenia.\nTwoje konto jest nieaktywne.");
//         request.getRequestDispatcher("/").forward(request, response);
         response.sendRedirect("/");
      }
      
   }
   
   public void init(FilterConfig config) throws ServletException {
      
   }
   
}
