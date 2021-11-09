<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">

<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li>Witaj ${principalUser.name}</li>
            <li><a href="/logout">wyloguj</a> </li>
        </ul>

        <ul>
            <li><a href="/admin/institutions" class="btn btn--without-border active">fundacje</a></li>
            <li><a href="/admin/admins" class="btn btn--without-border">admini</a></li>
            <li><a href="/admin/users" class="btn btn--without-border">użytkownicy</a></li>
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