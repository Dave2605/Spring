<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Subjects</title>
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
    <tr><th>ID</th><th>Name</th><th>Subject Group</th><th>Pass Score</th><th>Teacher</th></tr>
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <th>${subject.id}</th><th>${subject.name}</th><th>${subject.subjectGroup}</th><th>${subject.passScore}</th>
            <th>${subject.teacher.firstName} ${subject.teacher.secondName}</th><th></th>
        </tr>
    </c:forEach>
</table>

<p/>

<form action="/subject" method="get">
    <input type="text" name="id"/>
    <input type="submit" value="Edit Subject">
</form>

<form action="/subject/delete" method="post">
    <input type="text" name="id"/>
    <input type="submit" value="Delete Subject">
</form>

<p/>

<form action="/"><input type="submit" value="Back to Main Page"></form>
</body>
</html>
