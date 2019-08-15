<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 10.08.2019
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Polindrom page</title>
</head>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login Page</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
</head>

<body class="text-center">

<spring:form class="form-signin" action="/palindromes" modelAttribute="palindromes" method="post">
    <h1 class="h3 mb-3 font-weight-normal">Please input the palindrom</h1>
    <label for="numbers" class="sr-only">number of palindromes</label>
    <spring:input path="numbers" id="numbers" class="form-control"/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">find</button>
</spring:form>
</body>
</html>
