package com.example.Lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowFacultiesServlet", value = "/ShowFacultiesServlet")
public class ShowFacultiesServlet extends HttpServlet {
    City city;

    @Override
    public void init() throws ServletException {
        city = new City();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String universityName = request.getParameter("u");
        University university = city.findUniversityByName(universityName);
        request.setAttribute("university", university);
        request.getRequestDispatcher("faculties.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
