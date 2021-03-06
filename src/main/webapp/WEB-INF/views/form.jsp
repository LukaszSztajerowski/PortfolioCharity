<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Add donation</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/5</div>

        <form:form method="post" action="/addDonation" modelAttribute="donation">

            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                    <%--                <form:checkboxes path="categories"--%>
                    <%--                                 items="${categories}" itemLabel="name" multiple="true" id="categories"/>--%>

                <c:forEach items="${categories}" var="category">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input
                                    type="checkbox"
                                    name="categories"
                                    value="${category.id}"
                            />
                            <span class="checkbox"></span>
                            <span class="description">
                                    ${category.name}</span>
                        </label>
                    </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input path="quantity" id="quantity"/>
                    </label>

                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>


            <!-- STEP 3 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                    <%--                <form:radiobuttons path="institution" items="${institutions}" itemLabel="name" id="institution"/>--%>
                <c:forEach items="${institutions}" var="institution">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="institution" value="${institution.id}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                                  <div class="title">${institution.name}</div>
                                  <div class="subtitle">
                                          ${institution.description}
                                  </div>
                            </span>
                        </label>
                    </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>
                <div class="form-group form-group--inline">
                    <label>
                        kod pocztowy<form:input path="zipCode" id="zipCode"/><br>
                    </label>
                </div>
                <div class="form-group form-group--inline">
                    <label>
                        ulica <form:input path="street" id="street"/><br>
                    </label>
                </div>
                <div class="form-group form-group--inline">
                    <label>
                        miasto <form:input path="city" id="city"/><br>
                    </label>
                </div>
                <div class="form-group form-group--inline">
                    <label>
                        komentarz<form:textarea path="pickUpComment" id="pickUpComment"/><br>
                    </label>
                </div>
                <div class="form-group form-group--inline">
                    <label>
                        data doręczenia <form:input type="date" path="pickUpDate" id="pickUpDate"/><br>
                    </label>
                </div>
                <div class="form-group form-group--inline">
                    <label>
                        godzina doręczenia <form:input type="time" path="pickUpTime" id="pickUpTime"/><br>


                    </label>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text" id="quantityAndCategories-result"></span>

                            </li>
                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text" id="institution-result">
                                </span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="street-result"></li>
                                <li id="city-result"></li>
                                <li id="zipCode-result"></li>

                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li id="pickUpDate-result"></li>
                                <li id="pickUpTime-result"></li>
                                <li id="pickUpComment-result"></li>

                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
    </div>
</section>

<jsp:include page="footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>

</body>
</html>
