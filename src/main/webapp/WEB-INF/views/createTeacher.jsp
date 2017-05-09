<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Teacher</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body>
<form:form action="create" method="post" commandName="teacher"><br>
    <input type="text" name="firstName" placeholder="First Name" value="${teacher.firstName}"/>
    <form:errors path="firstName" cssClass="error"/><br>
    <input type="text" name="secondName" placeholder="Second Name" value="${teacher.secondName}"/>
    <form:errors path="secondName" cssClass="error"/><br>
    <input type="text" name="age" placeholder="Age" value="${teacher.age}"/>
    <form:errors path="age" cssClass="error"/><br>
    <input type="text" name="email" placeholder="Email" value="${teacher.email}"/>
    <form:errors path="email" cssClass="error"/><br>
    <p/>
    <input type="submit" value="Create Teacher">
</form:form>
</body>
</html>