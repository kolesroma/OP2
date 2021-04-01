<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main page</title>
</head>
<body>
<%!
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int a_to = 0;
    int b_to = 0;
    int c_to = 0;
    int d_to = 0;
    int a_step = 0;
    int b_step = 0;
    int c_step = 0;
    int d_step = 0;
%>
<%
    if (request.getAttribute("a") != null) {
        this.a = (int) request.getAttribute("a");
    }
    if (request.getAttribute("b") != null) {
        this.b = (int) request.getAttribute("b");
    }
    if (request.getAttribute("c") != null) {
        this.c = (int) request.getAttribute("c");
    }
    if (request.getAttribute("d") != null) {
        this.d = (int) request.getAttribute("d");
    }
%>
<form action="TaskSolver" method="get">
    a: from = <input type="text" name="a" value="<%=a%>"/>
    to <input type="text" name="a_to" value="<%=a_to%>"/>
    step <input type="text" name="a_step" value="<%=a_step%>"/><br>
    b: from = <input type="text" name="b" value="<%=b%>"/>
    to <input type="text" name="b_to" value="<%=b_to%>"/>
    step <input type="text" name="b_step" value="<%=b_step%>"/><br>
    c: from = <input type="text" name="c" value="<%=c%>"/>
    to <input type="text" name="c_to" value="<%=c_to%>"/>
    step <input type="text" name="c_step" value="<%=c_step%>"/><br>
    d: from = <input type="text" name="d" value="<%=d%>"/>
    to <input type="text" name="d_to" value="<%=d_to%>"/>
    step <input type="text" name="d_step" value="<%=d_step%>"/><br>
    <input type="submit" value="Solve task"/>
</form>
<% if (request.getAttribute("result") != null) {
%>

<table cellpadding="4" border="2">
    <tr>
        <td>Result</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
    </tr>
    <tr>
        <td><%=request.getAttribute("result")%>
        </td>
        <td><%=this.a%>
        </td>
        <td><%=this.b%>
        </td>
        <td><%=this.c%>
        </td>
        <td><%=this.d%>
        </td>
    </tr>
</table>
<hr>
<br>
<% }
%>


</body>
</html>