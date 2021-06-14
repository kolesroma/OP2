package com.example.Lab4;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CreateUniversityServlet", value = "/CreateUniversityServlet")
public class CreateUniversityServlet extends HttpServlet {
    City city;

    @Override
    public void init() throws ServletException {
        city = new City();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        University kpi = new University("kpi");
        city.addUniversity(kpi);
        Faculty fics = new Faculty("fics");
        fics.addStudent(new Student("roma", "koles", "100", "100"));
        kpi.addFaculty(fics);
        kpi.addFaculty(new Faculty("fmm"));
        kpi.addFaculty(new Faculty("ipsa"));
        req.setAttribute("city", city);
        req.getRequestDispatcher("universities.jsp").forward(req, resp);
//        req.getRequestDispatcher("ShowUniversitiesServlet").forward(req, resp);
    }
}