<%--
  Created by IntelliJ IDEA.
  User: ilyamikheev
  Date: 17.08.18
  Time: 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>

<div class="fixed">

    <div class="header">
        <div class="header__logo">
            Barabånk
        </div>
        <div class="header__menu">
            <ul>
                <a href="${pageContext.request.contextPath}/index"><li>Главная</li></a>
                <li>Частным клиентам</li>
                <li>Партнерство</li>
                <li>Отделения</li>
            </ul>
        </div>
    </div>

    <div class="information-bar">
        <h2 class="information-bar__greeting">Добро Пожаловать в Barabånk!</h2>
        <div class="signInSingOut"><%= request.getAttribute("signInSingOut")%></div>
    </div>

</div>