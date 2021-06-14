<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Universities</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<form action="AddUniversityServlet" method="post">
    <input type="text" name="universityName" value=""> <br>
    <input type="submit" value="add"> <br>
</form>

<c:forEach var="university" items="${requestScope.city.universities}">
    <table>
        <tr>
            <td>
                <a href="ShowFacultiesServlet?u=${university.name}">${university}</a>
            </td>
        </tr>
    </table>
</c:forEach>


</body>
</html>