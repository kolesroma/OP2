package com.example.Lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddStudentServlet", value = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    City city;

    @Override
    public void init() throws ServletException {
        city = new City();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        String studentSurname = request.getParameter("studentSurname");
        String studentId = request.getParameter("studentId");
        String studentRate = request.getParameter("studentRate");
        String facultyName = request.getParameter("facultyName");
        String universityName = request.getParameter("universityName");

        University university = city.findUniversityByName(universityName);
        Faculty faculty = university.getFacultyByName(facultyName);
        faculty.addStudent(new Student(studentName, studentSurname, studentId, studentRate));
//        request.setAttribute("faculty", faculty);
//        request.getRequestDispatcher("students.jsp").forward(request, response);
        response.sendRedirect("ShowUniversitiesServlet");
    }
}
