package com.example.Lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddUniversityServlet", value = "/AddUniversityServlet")
public class AddUniversityServlet extends HttpServlet {
    City city;

    @Override
    public void init() throws ServletException {
        city = new City();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String universityName = request.getParameter("universityName");
        city.addUniversity(new University(universityName));
        request.setAttribute("city", city);
        request.getRequestDispatcher("universities.jsp").forward(request, response);
//        request.getRequestDispatcher("ShowUniversitiesServlet").forward(request, response);
    }
}
