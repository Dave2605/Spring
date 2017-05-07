<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Subject</title>
</head>
<body>
<form action="subject/update" method="post">
    <input type="text" name="id" value="${subject.id}" readonly/><br>
    <input type="text" name="name" value="${subject.name}"/><br>
    <input type="text" name="subjectGroup" value="${subject.subjectGroup}"/><br>
    <input type="text" name="passScore" value="${subject.passScore}"/><br>
    <tr><td>
        <form:select name="teacherId" path="teachers">
            <option value="${subject.teacher.id}">Select Teacher</option>
            <c:forEach var="teacher" items="${teachers}">
                <form:option value="${teacher.id}"><c:out value="${teacher.firstName} ${teacher.secondName}"/></form:option>
            </c:forEach>
        </form:select>
    </td></tr>

    <p/>

    <input type="submit" value="Edit Subject">
</form>

<p/>

<form action="subject/getAll"><input type="submit" value="Back to Subjects"></form>
</body>
</html>
