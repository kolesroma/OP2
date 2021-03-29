package com.example.Lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import static java.lang.Math.*;

@WebServlet(name = "CalculateServlet", value = "/CalculateServlet")
public class CalculateServlet extends HttpServlet {
    public double calculateFunction(double a, double b, double c, double d) {
        return sqrt(abs(sin(a) - 4 * Math.log(b) / pow(c, d)));
    }

    public ArrayList<Double> getArrayList(double aFrom, double aTo, double aStep) {
        ArrayList<Double> aValues = new ArrayList<>();
        while (aFrom <= aTo) {
            aValues.add(aFrom);
            aFrom += aStep;
        }
        return aValues;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double aFrom = Double.parseDouble(request.getParameter("aFrom"));
        double aTo = Double.parseDouble(request.getParameter("aTo"));
        double aStep = Double.parseDouble(request.getParameter("aStep"));

        double bFrom = Double.parseDouble(request.getParameter("bFrom"));
        double bTo = Double.parseDouble(request.getParameter("bTo"));
        double bStep = Double.parseDouble(request.getParameter("bStep"));

        double cFrom = Double.parseDouble(request.getParameter("cFrom"));
        double cTo = Double.parseDouble(request.getParameter("cTo"));
        double cStep = Double.parseDouble(request.getParameter("cStep"));

        double dFrom = Double.parseDouble(request.getParameter("dFrom"));
        double dTo = Double.parseDouble(request.getParameter("dTo"));
        double dStep = Double.parseDouble(request.getParameter("dStep"));


        ArrayList<ArrayList<Double>> data = new ArrayList<>();

        ArrayList<Double> aValues = getArrayList(aFrom, aTo, aStep);
        ArrayList<Double> bValues = getArrayList(bFrom, bTo, bStep);
        ArrayList<Double> cValues = getArrayList(cFrom, cTo, cStep);
        ArrayList<Double> dValues = getArrayList(dFrom, dTo, dStep);

        for (double a : aValues)
            for (double b : bValues)
                for (double c : cValues)
                    for (double d : dValues) {
                        ArrayList<Double> temp = new ArrayList<>();
                        temp.add(a);
                        temp.add(b);
                        temp.add(c);
                        temp.add(d);
                        temp.add(calculateFunction(a, b, c, d));
                        data.add(temp);
                    }

        request.setAttribute("data", data);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}
