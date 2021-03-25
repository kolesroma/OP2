package com.example.lab1web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RomanServlet", value = "/RomanServlet")
public class RomanServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Kolesnyk Roman";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href=https://github.com>" + "github" + "</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
