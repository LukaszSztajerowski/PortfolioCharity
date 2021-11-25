<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">

<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <sec:authorize access="isAuthenticated()">
            <li><p>Witaj <sec:authentication property="principal.username"/></p></li>
            <li>
                <form action="/logout" method="post">
                    <input type="submit" value="Wyloguj">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </li>
            </sec:authorize>
        </ul>

        <ul>
            <li><a href="/admin/institutions" class="btn btn--without-border active">fundacje</a></li>
            <li><a href="/admin/adminList" class="btn btn--without-border">admini</a></li>
            <li><a href="/admin/usersList" class="btn btn--without-border">użytkownicy</a></li>
            <li><a href="/admin/donations" class="btn btn--without-border">darowizny</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br/>
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>
        </div>
    </div>
</header>