<%--
  Created by IntelliJ IDEA.
  User: ilyamiheev
  Date: 06/08/2018
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Barabånk - регистрация нового пользователя</title>
    <%@include file="/WEB-INF/views/page_members/styles.jsp"%>
</head>
<body>
<%@include file="/WEB-INF/views/page_members/header.jsp"%>

<div class = "content">
    <h1>Регистрация нового клиента Barabånk</h1>
    <form class="registration-form" action="/registration" method="POST">
        <div class="cont">
            <label>Имя:<star>*</star></label>
            <input class="input" name="first-name" placeholder="Имя">
        </div>
        <div>
            <label>Фамилия:<star>*</star></label>
            <input class="input" name="second-name" placeholder="Фамилия">
        </div>
        <div>
            <label>Отчество(при наличии): </label>
            <input class="input" name="middle-name" placeholder="Отчество">
        </div>
        <div>
            <label>Паспортные данные ID:<star>*</star></label>
            <input class="input" name="ID" placeholder="ID">
        </div>
        <div>
            <label>Телефон:<star>*</star></label>
            <input class="input" name="telephone" placeholder="Телефон">
        </div>
        <div>
            <label>Адрес:<star>*</star></label>
            <input class="input" name="address" placeholder="Адрес">
        </div>
        <div>
            <label>Дата рождения:<star>*</star></label>
            <input class="input" type="date" name="birth-day" placeholder="Телефон">
        </div>
        <div>
            <label>Пароль:<star>*</star></label>
            <input class="input" type="password" name="password" placeholder="Пароль">
        </div>
        <div>
            <label>Подтвердите пароль:<star>*</star></label>
            <input class="input" type="password" name="repeat-password" placeholder="Подтверждение пароля">
        </div>
        <button class = "regular-button green-button" type="submit">Подтвердить</button>
    </form>
</div>

<%@include file="/WEB-INF/views/page_members/footer.jsp"%>
</body>
</html>
