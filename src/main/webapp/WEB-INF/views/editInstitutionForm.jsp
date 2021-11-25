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
    <title>Edycja instytucji</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<jsp:include page="adminheader.jsp"/>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" action="/admin/editInstitution" modelAttribute="institutionToEdit">
        <div class="form-group">
           <h3> nazwa fundacji</h3> <form:input path="name" placeholder="${institutionToEdit.name}"/>
        </div>

        <div class="form-group">
            <h3>opis fundacji</h3> <form:input path="description" placeholder="${institutionToEdit.description}"/>
        </div>

        <div class="form-group">
            <h3>czy fundacja/organizacja jest aktywna</h3>
            Aktywna <form:radiobutton path="active" value="1"/>
            Nie aktywna <form:radiobutton path="active" value="false"/>
            <form:hidden path="id" value="${institutionToEdit.id}"/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Edytuj fundację</button>
        </div>
    </form:form>
</section>



<script src="<c:url value="/resources/js/app.js"/>"></script>

</body>
</html>
