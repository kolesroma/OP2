<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.Lab3.CalculateServlet" %>
<%@ page import="static java.lang.Math.sqrt" %>
<%@ page import="static java.lang.Math.abs" %>
<%@ page import="static java.lang.Math.*" %>
<%@ page import="static java.lang.Math.pow" %>
<hr>
<table width="660" bgcolor="#00ced1" border="1">
    <tr>
        <th>a</th>
        <th>b</th>
        <th>c</th>
        <th>d</th>
        <th>f(x)</th>
    </tr>
        <%
            ArrayList<ArrayList<Double>> data = ((ArrayList<ArrayList<Double>>) request.getAttribute("data"));

            for (ArrayList<Double> al : data) {
        %>
    <tr>
                <td align="center" bgcolor=<%=al.get(4) == 1 ? "" : "#dc143c"%>><%=al.get(0)%></td>
                <td align="center" bgcolor=<%=al.get(5) == 1 ? "" : "#dc143c"%>><%=al.get(1)%></td>
                <td align="center" bgcolor=<%=al.get(6) == 1 ? "" : "#dc143c"%>><%=al.get(2)%></td>
                <td align="center" bgcolor=<%=al.get(7) == 1 ? "" : "#dc143c"%>><%=al.get(3)%></td>
                <td align="center"><%=al.get(8) != null ? al.get(8) : ":("%></td>
    </tr>
        <%
            }

        %>
</table>