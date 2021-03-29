package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Math.*;

@WebServlet(name = "TaskSolver", value = "/TaskSolver")
public class TaskSolver extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Integer a = Integer.parseInt(request.getParameter("a"));
            Integer b = Integer.parseInt(request.getParameter("b"));
            Integer c = Integer.parseInt(request.getParameter("c"));
            Integer d = Integer.parseInt(request.getParameter("d"));
            request.setAttribute("a", a);
            request.setAttribute("b", b);
            request.setAttribute("c", c);
            request.setAttribute("d", d);
            Cookie cookie = new Cookie("a", a.toString());
            Cookie cookie1 = new Cookie("b", b.toString());
            Cookie cookie2 = new Cookie("c", c.toString());
            Cookie cookie3 = new Cookie("d", d.toString());
            cookie.setMaxAge(7000);
            cookie1.setMaxAge(7000);
            cookie2.setMaxAge(7000);
            cookie3.setMaxAge(7000);
            Cookie[] cookies = request.getCookies();
            double result = sqrt(abs(sin(a) - 4 * Math.log(b) / pow(c, d)));
            request.setAttribute("result", result);

        } catch (NumberFormatException e) {
            request.setAttribute("result", "Invalid parameter");

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }


    }
}
