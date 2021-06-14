package com.example.Lab4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowStudentsServlet", value = "/ShowStudentsServlet")
public class ShowStudentsServlet extends HttpServlet {
    City city;

    @Override
    public void init() throws ServletException {
        city = new City();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String universityName = request.getParameter("u");
        String facultyName = request.getParameter("f");
        University university = city.findUniversityByName(universityName);
        Faculty faculty = university.getFacultyByName(facultyName);
        request.setAttribute("faculty", faculty);
        request.setAttribute("university", university);
        request.getRequestDispatcher("students.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
