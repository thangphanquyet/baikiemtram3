<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/2/2024
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" class="table table-striped">
    <input type="text" class="form-label"  name="name" placeholder="Mời bạn nhập tên vào"><br>
    <input type="text" class="form-label"  name="age" placeholder="Mời bạn nhập tuổi"><br>
    <select name="address" class="form-label"><br>
        <c:forEach items="${addressList}" var="address">
            <option value="${address.id}">${address.name}</option>
        </c:forEach>
    </select>
    <button type="submit" class="bi bi-dpad" >save</button>

</form>
</body>
</html>