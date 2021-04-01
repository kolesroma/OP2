package com.example.Lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CalculateServlet", value = "/CalculateServlet")
public class CalculateServlet extends HttpServlet {
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

        String buttonValue = request.getParameter("radioButton");
        Context formula = selectFormula(buttonValue);
//        boolean[] odzBooleanArray = formula.getOdz();
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
                        boolean[] odzBooleanArray = formula.getOdz(a, b, c, d);
                        for (boolean bol : odzBooleanArray){
                            if (bol)
                                temp.add(1d);
                            else
                                temp.add(0d);
                        }

                        double result = formula.calculate(a, b, c, d);
                        if (Double.isFinite(result))
                            temp.add(result);
                        else
                            temp.add(null);
                        data.add(temp);
                    }

        request.setAttribute("data", data);


        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }

    private Context selectFormula(String buttonValue) {
        switch (buttonValue) {
            case "1":
                return new Context(new Formula1());
            case "11":
                return new Context(new Formula11());
            case "21":
                return new Context(new Formula21());
            default:
                throw new IllegalStateException("Unexpected value: " + buttonValue);
        }
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
