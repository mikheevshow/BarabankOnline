<%--
  Created by IntelliJ IDEA.
  User: ilyamiheev
  Date: 06/08/2018
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Barabånk - входа</title>
    <%@include file="/WEB-INF/views/page_members/styles.jsp"%>
</head>
<body>

<%@include file="/WEB-INF/views/page_members/header.jsp"%>

<div class = "blocks">
    <div class="autorization-block">

        <form class = "autorization-block__form" action="${pageContext.request.contextPath}/login" method="POST">
            <h1>Вход в личный кабинет</h1>
            ${userStatus}
            <div>
                <label>Номер телефона:</label>
                <input class = "autorization-block__form__field" type="text" name="phone" placeholder="Телефон" >
            </div>

            <div>
                <label>Пароль:</label>
                <input class = "autorization-block__form__field" type="password" name="password" placeholder="Пароль">
            </div>
            <input class = "regular-button green-button" type="submit" name="Вход" value="Вход">
            <a class = "autorization-block__forgot-password-reference" href="">Забыли пароль?</a>
        </form>

    </div>
    <div class="information-block">
        <h2>Уважаемый клиент!</h2>
        <p>Если вас просят ввести пароль входа в Barabånk для отмены или аннулирования операции, не делайте этого. Это мошенники.</p>
        <h2>Новый пользователь? Зарегестрируйтесь!</h2>
        <a href="/registration"><div class="regular-button blue-button">Регистрация</div></a>
    </div>
</div>

<%@include file="/WEB-INF/views/page_members/footer.jsp"%>

</body>
</html>