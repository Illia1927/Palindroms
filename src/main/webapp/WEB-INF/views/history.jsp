<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 15.08.2019
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<h2>History : </h2>
<c:forEach var="numbers" items="${numbers}">
    <h4>First name: <c:out value="${numbers.numbers}"/></h4>
    <hr style="margin-bottom: 10px"/>
</c:forEach>
<a class="nav-link" href="<c:url value="/home"/>">go back home</a>
</body>
</html>
