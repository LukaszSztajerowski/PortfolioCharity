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
    <title>Admin Page</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<jsp:include page="adminheader.jsp"/>
<section class="about-us">
<div class="help--slides active" data-id="1">
    <ul class="help--slides-items">
        <c:forEach items="${admins}" var="adminUser">
            <li>
                <div class="col">
                    <div class="title">${adminUser.name} ${adminUser.lastName}</div>
                    <div class="subtitle">
                        <a href="admin/addAdmin/${adminUser.name}"></a>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
</section>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
