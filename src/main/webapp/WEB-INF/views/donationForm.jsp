<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="/addDonation" modelAttribute="donation">

    Kategorie <form:checkboxes path="categories"
                               items="${categories}" itemLabel="name"/><br>

    instytucja<form:select path="institution" items="${institutions}" itemLabel="name" multiple="true"/><br>

    kod pocztowy<form:input path="zipCode"/><br>

    ulica <form:input path="street"/><br>

    miasto <form:input path="city"/><br>

    ilość worków <form:input path="quantity"/><br>

    komentarz<form:textarea path="pickUpComment"/><br>

    data doręczenia <form:input type="date" path="pickUpDate"/><br>

    godzina doręczenia <form:input type="time" path="pickUpTime"/><br>

    <input type="submit" value="Dodaj paczkę">

</form:form>