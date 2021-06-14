package com.example.Lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowUniversitiesServlet", value = "/ShowUniversitiesServlet")
public class ShowUniversitiesServlet extends HttpServlet {
    City city;

    @Override
    public void init() throws ServletException {
        city = new City();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("city", city);
        req.getRequestDispatcher("universities.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
