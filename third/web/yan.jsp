<%--
  Created by IntelliJ IDEA.
  User: selo
  Date: 17.07.2019
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring5 MVC Hibernate Demo</title
</head>
<body>
<h1>Input Form</h1>
<form action="addUser" method="post" modelAttribute="user">
    <table>
        <tr>
            <td>Name</td>
            <td>
                <input path="name" /> <br />
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input path="email" /> <br />
            </td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Submit</button></td>
        </tr>
    </table>
</form>

</body>
</html>
