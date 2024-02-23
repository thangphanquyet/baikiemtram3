<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/2/2024
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>quản lý sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<div>
    <input type="text"  name="searchQuery" placeholder="tìm kiếm" width="200px">
    <button type="submit" class="btn btn-primary">search</button>
    <ul>
        <a href="student?action=create">add new</a></button></a>
    </ul>
</div>
<div align="center">
    <form action="student" method="get">
        <%--        <input type="text"  name="searchQuery" placeholder="tìm kiếm" width="200px">--%>
        <%--        <button type="submit" class="btn btn-primary">Tìm Kiếm</button>--%>
        <button type="submit" >show list</button>
    </form>
    <table border="1" cellpadding="4" class="table table-striped">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>age</th>
            <th>address</th>
            <th>action</th>
        </tr>
        <c:forEach var="student" items="${list}">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.age}"/></td>
                <td><c:out value="${student.address}"/></td>
                <td><a href="?action=delete&id=${student.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tr>
    </table>
    <%--    <button type="button" class="btn btn-primary">Primary Button</button>--%>
</div>
<script src="resources/bootstrap/bootstrap.min.js"></script>
</body>
</html>