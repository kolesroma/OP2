package com.example.Lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddFacultyServlet", value = "/AddFacultyServlet")
public class AddFacultyServlet extends HttpServlet {
    City city;

    @Override
    public void init() throws ServletException {
        city = new City();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String facultyName = request.getParameter("facultyName");
        String universityName = request.getParameter("universityName");
        University currentUniversity = city.findUniversityByName(universityName);
        currentUniversity.addFaculty(new Faculty(facultyName));
        request.setAttribute("university", currentUniversity);
        request.getRequestDispatcher("faculties.jsp").forward(request, response);
    }
}
