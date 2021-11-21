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
    <title>Edycja Użytkownika</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<jsp:include page="adminheader.jsp"/>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" action="/admin/editAdmin" modelAttribute="userToEdit">
        <div class="form-group">
            <form:input path="name" placeholder="${userToEdit.name}"/>
        </div>

        <div class="form-group">
            <form:input path="lastName" placeholder="${userToEdit.lastName}"/>
        </div>

        <div class="form-group">
            <form:hidden path="id" value="${userToEdit.id}"/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Edytuj dane użytkownika </button>
        </div>
    </form:form>
</section>



<script src="<c:url value="/resources/js/app.js"/>"></script>

</body>
</html>
