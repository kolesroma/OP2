package com.example.Lab2;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import static java.lang.Math.*;

@WebServlet(name = "Task1Servlet", value = "/Task1Servlet")
public class Task1Servlet extends HttpServlet {
    private double determineFunctionValue(double a, double b, double c, double d) {
        return sqrt(abs(sin(a) - 4 * Math.log(b) / pow(c, d)));
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        double d = Double.parseDouble(request.getParameter("d"));
        double result = determineFunctionValue(a, b, c, d);
        if (!Double.isFinite(result))
            response.sendRedirect("wrongParams.html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> sqrt(abs(sin(a) - 4 * Math.log(b) / pow(c, d))) </h1>");
            out.println("<h1>" + result + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}