<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Subject</title>
</head>
<body>
<form action="/subject/create" method="post">
    <input type="text" name="name" placeholder="Name"/><br>
    <input type="text" name="subjectGroup" placeholder="Subject Group"/><br>
    <input type="text" name="passScore" placeholder="PassScore"/><br>
    <tr><td>
        <form:select name="teacherId" path="teachers">
            <option value="${subject.teacher.id}">Select Teacher</option>
            <c:forEach var="teacher" items="${teachers}">
                <form:option value="${teacher.id}"><c:out value="${teacher.firstName} ${teacher.secondName}"/></form:option>
            </c:forEach>
        </form:select>
    </td></tr>

    <p/>

    <input type="submit" value="Create Subject">
</form>

</body>
</html>
