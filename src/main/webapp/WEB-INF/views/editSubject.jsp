<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Subject</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body>
<form:form action="subject/update" method="post" commandName="subject">
    <input type="text" name="id" value="${subject.id}" readonly/><br>
    <input type="text" name="name" value="${subject.name}"/>
    <form:errors path="name" cssClass="error"/><br>
    <input type="text" name="subjectGroup" value="${subject.subjectGroup}"/>
    <form:errors path="subjectGroup" cssClass="error"/><br>
    <input type="text" name="passScore" value="${subject.passScore}"/>
    <form:errors path="passScore" cssClass="error"/><br>
    <tr><td>
        <form:select name="teacherId" path="teacherId">
            <c:forEach var="teacher" items="${teachers}">
                <form:option value="${teacher.id}"><c:out value="${teacher.secondName} ${teacher.firstName}"/></form:option>
            </c:forEach>
        </form:select>
    </td></tr>
    <p/>
    <input type="submit" value="Edit Subject">
</form:form>
<p/>
<form action="subject/all"><input type="submit" value="Back to Subjects"></form>
</body>
</html>
