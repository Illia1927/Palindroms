<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 15.08.2019
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
    <title>True</title>
</head>
<body class="text-center">
<spring:form class="form-signin" action="/history" modelAttribute="numbers" method="post">
    <h4 class="h3 mb-3 font-weight-normal">Number : <c:out value="${palindromes.numbers}"/> is not palindromes!</h4>
    <a class="nav-link" href="<c:url value="/history"/>">history</a>
    <a class="nav-link" href="<c:url value="/home"/>">go back home</a>
</spring:form>
</body>
</html>
