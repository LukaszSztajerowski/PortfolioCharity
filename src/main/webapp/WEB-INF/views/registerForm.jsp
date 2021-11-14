<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<section class="login-page">
    <h2>Załóż konto</h2>
<form:form method="post" action="/register" modelAttribute="user">
    <div class="form-group">
            <form:input path="name" placeholder="imię"/>
        </div>

        <div class="form-group">
            <form:input path="lastName" placeholder="nazwisko"/>
        </div>

        <div class="form-group">
            <form:input path="email" placeholder="email"/>
        </div>

        <div class="form-group">
            <form:input path="password" placeholder="password" type="password"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<jsp:include page="footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>

</body>
</html>
