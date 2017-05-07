<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Teacher</title>
</head>
<body>
<form action="teacher/update" method="post">
    <input type="text" name="id" value="${teacher.id}" readonly/><br>
    <input type="text" name="firstName" value="${teacher.firstName}"/><br>
    <input type="text" name="secondName" value="${teacher.secondName}"/><br>
    <input type="text" name="age" value="${teacher.age}"/><br>
    <input type="text" name="email" value="${teacher.email}"/><br>

    <p/>

    <input type="submit" value="Edit Teacher">
</form>

<p/>

<form action="subject/getAll"><input type="submit" value="Back to Teachers"></form>
</body>
</html>
