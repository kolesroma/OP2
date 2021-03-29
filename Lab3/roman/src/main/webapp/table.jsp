<%@ page import="java.util.ArrayList" %>
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
                <td align="center"><%=al.get(0)%></td>
                <td align="center"><%=al.get(1)%></td>
                <td align="center"><%=al.get(2)%></td>
                <td align="center"><%=al.get(3)%></td>
                <td align="center"><%=al.get(4)%></td>
    </tr>
        <%
            }

        %>
</table>