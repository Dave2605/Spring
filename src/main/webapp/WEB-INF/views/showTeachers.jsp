<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Teachers</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        tr:hover{background-color:#f5f5f5}
    </style>
</head>
<body>
<table>
    <tr><th>ID</th><th>First Name</th><th>Second Name</th><th>Age</th><th>Email</th></tr>
    <c:forEach var="teacher" items="${teachers}">
        <tr>
            <th>${teacher.id}</th><th>${teacher.firstName}</th><th>${teacher.secondName}</th><th>${teacher.age}</th>
            <th>${teacher.email}</th><th></th>
        </tr>
    </c:forEach>
</table>

<p/>

<form action="/teacher" method="get">
    <input type="text" name="id"/>
    <input type="submit" value="Edit Teacher">
</form>

<form action="/teacher/delete" method="post">
    <input type="text" name="id"/>
    <input type="submit" value="Delete Teacher">
</form>

<p/>

<form action="/"><input type="submit" value="Back to Main Page"></form>
</body>
</html>
