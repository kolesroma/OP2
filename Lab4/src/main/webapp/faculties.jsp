<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculties</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<form action="AddFacultyServlet" method="post">
    <input type="text" name="facultyName" value=""> <br>
    <input type="hidden" name="universityName" value="${requestScope.university.name}">
    <input type="submit" value="add"> <br>
</form>

<c:forEach var="fac" items="${requestScope.university.faculties}">
    <table>
        <tr>
            <td>
                <a href="ShowStudentsServlet?u=${requestScope.university.name}&f=${fac.name}">${fac}</a>
            </td>
        </tr>
    </table>
</c:forEach>


</body>
</html>