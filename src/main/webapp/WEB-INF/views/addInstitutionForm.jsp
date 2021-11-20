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
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<jsp:include page="adminheader.jsp"/>

<section class="login-page">
    <h2>dodaj nową fundację</h2>
    <form:form method="post" action="/admin/addInstitution" modelAttribute="institution">
        <div class="form-group">
            <form:input path="name" placeholder="nazwa fundacji"/>
        </div>

        <div class="form-group">
            <form:input path="description" placeholder="opis fundacji "/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">dodaj nową fundację</button>
        </div>
    </form:form>
</section>



<script src="<c:url value="/resources/js/app.js"/>"></script>

</body>
</html>
