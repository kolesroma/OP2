<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<form action="AddStudentServlet" method="post">
    <input type="text" name="studentName" value=""> <br>
    <input type="text" name="studentSurname" value=""> <br>
    <input type="text" name="studentId" value=""> <br>
    <input type="text" name="studentRate" value=""> <br>
    <input type="hidden" name="facultyName" value="${requestScope.faculty.name}">
    <input type="hidden" name="universityName" value="${requestScope.university.name}">
    <input type="submit" value="add"> <br>
</form>

<c:forEach var="stud" items="${requestScope.faculty.students}">
    <table>
        <tr>
            <td>
                ${stud}
            </td>
        </tr>
    </table>
</c:forEach>


</body>
</html>