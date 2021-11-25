<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>fundacje</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<jsp:include page="adminheader.jsp"/>
<section class="help">

<div class="help--slides active" data-id="1">
    <ul>
        <li><a href="/admin/addInstitution" class="btn btn--without-border active">dodaj nowa fundację</a></li>

    </ul>
    <br>
    <ul class="help--slides-items">

        <c:forEach items="${institutions}" var="instit" varStatus="i" step="2">
            <li>
                <div class="col">
                    <div class="title">${institutions[i.index].name}</div>
                     <div class="subtitle">aktywna: ${institutions[i.index].active}</div>
                    <div class="subtitle"><a href="/admin/editInstitution/${institutions[i.index].id}">edytuj</a> </div>
                    <div class="subtitle"><a href="/admin/deleteInstitution/${institutions[i.index].id}">usuń</a> </div>


                </div>
                <div class="col">
                    <div class="title">${institutions[i.index+1].name}</div>
                    <div class="subtitle">aktywna: ${institutions[i.index+1].active}</div>
                    <div class="subtitle"><a href="/admin/editInstitution/${institutions[i.index+1].id}">edytuj</a> </div>
                    <div class="subtitle"><a href="/admin/deleteInstitution/${institutions[i.index+1].id}">usuń</a> </div>
                </div>
            </li>
        </c:forEach>

    </ul>
</div>
</section>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
