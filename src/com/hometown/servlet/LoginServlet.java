package com.hometown.servlet;

import com.hometown.dao.UserDAO;
import com.hometown.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // In real app, hash this!

        User user = userDAO.login(username, password);
        if (user != null) {
            System.out.println("DEBUG: User found, creating session for " + user.getUsername());
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("MainServlet");
        } else {
            System.out.println("DEBUG: User not found or error occurred.");
            request.setAttribute("error", "Invalid username or password (Check server console for details)");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
