<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Subject</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body>
<form:form action="create" method="post" commandName="subject">
    <input type="text" name="name" placeholder="Name" value="${subject.name}"/>
    <form:errors path="name" cssClass="error"/><br>
    <input type="text" name="subjectGroup" placeholder="Subject Group" value="${subject.subjectGroup}"/>
    <form:errors path="subjectGroup" cssClass="error"/><br>
    <input type="text" name="passScore" placeholder="PassScore" value="${subject.passScore}"/>
    <form:errors path="passScore" cssClass="error"/><br>
    <tr><td>
        <form:select name="teacherId" path="teacherId">
            <c:forEach var="teacher" items="${teachers}">
                <form:option value="${teacher.id}"><c:out value="${teacher.secondName} ${teacher.firstName}"/></form:option>
            </c:forEach>
        </form:select>
    </td></tr>
    <p/>
    <input type="submit" value="Create Subject">
</form:form>
</body>
</html>
