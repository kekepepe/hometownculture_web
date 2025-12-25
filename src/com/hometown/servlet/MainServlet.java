package com.hometown.servlet;

import com.hometown.dao.CultureItemDAO;
import com.hometown.model.CultureItem;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private CultureItemDAO itemDAO = new CultureItemDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CultureItem> items = itemDAO.getAllItems();
        request.setAttribute("items", items);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
