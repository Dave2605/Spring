<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Teacher</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body>
<form:form action="" method="post" commandName="teacher">
    <input type="text" name="id" value="${teacher.id}" readonly/><br>
    <input type="text" name="firstName" value="${teacher.firstName}"/>
    <form:errors path="firstName" cssClass="error"/><br>
    <input type="text" name="secondName" value="${teacher.secondName}"/>
    <form:errors path="secondName" cssClass="error"/><br>
    <input type="text" name="age" value="${teacher.age}"/>
    <form:errors path="age" cssClass="error"/><br>
    <input type="text" name="email" value="${teacher.email}"/>
    <form:errors path="email" cssClass="error"/><br>
    <p/>
    <input type="submit" value="Edit Teacher">
</form:form>
<p/>
<form action="subject/all"><input type="submit" value="Back to Teachers"></form>
</body>
</html>
