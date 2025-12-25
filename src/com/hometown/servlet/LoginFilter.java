package com.hometown.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/MainServlet") // Only strictly protect MainServlet
public class LoginFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        System.out.println("DEBUG: LoginFilter processing request for " + request.getRequestURI());
        System.out.println("DEBUG: Session exists? " + (session != null) + ", LoggedIn? " + loggedIn);

        if (loggedIn) {
            chain.doFilter(request, response);
        } else {
            System.out.println("DEBUG: LoginFilter redirecting to login.jsp");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    public void destroy() {
    }
}
