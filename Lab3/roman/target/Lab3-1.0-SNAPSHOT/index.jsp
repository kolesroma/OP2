<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab3</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
    <hr><img src="img.jpg"><hr>
    <form action="CalculateServlet">
        a: from <input type="text" name="aFrom" value=<%=request.getParameter("aFrom") != null ? request.getParameter("aFrom") : 6%>>
        to <input type="text" name="aTo" value=<%=request.getParameter("aTo") != null ? request.getParameter("aTo") : 6%> >
        step <input type="text" name="aStep" value=<%=request.getParameter("aStep") != null ? request.getParameter("aStep") : 6%>> <br>

        b: from <input type="text" name="bFrom" value=<%=request.getParameter("bFrom") != null ? request.getParameter("bFrom") : 6%>>
        to <input type="text" name="bTo" value=<%=request.getParameter("bTo") != null ? request.getParameter("bTo") : 6%>>
        step <input type="text" name="bStep" value=<%=request.getParameter("bStep") != null ? request.getParameter("bStep") : 6%>> <br>

        c: from <input type="text" name="cFrom" value=<%=request.getParameter("cFrom") != null ? request.getParameter("cFrom") : 6%>>
        to <input type="text" name="cTo" value=<%=request.getParameter("cTo") != null ? request.getParameter("cTo") : 6%>>
        step <input type="text" name="cStep" value=<%=request.getParameter("cStep") != null ? request.getParameter("cStep") : 6%>> <br>

        d: from <input type="text" name="dFrom" value=<%=request.getParameter("dFrom") != null ? request.getParameter("dFrom") : 6%>>
        to <input type="text" name="dTo" value=<%=request.getParameter("dTo") != null ? request.getParameter("dTo") : 6%>>
        step <input type="text" name="dStep" value=<%=request.getParameter("dStep") != null ? request.getParameter("dStep") : 6%>> <br>

        <input type="submit"  value="Submit">
    </form>



<%
    if (request.getAttribute("data") != null) {
%>

    <%@include file="table.jsp"%>

<%
    }
%>

</body>
</html>