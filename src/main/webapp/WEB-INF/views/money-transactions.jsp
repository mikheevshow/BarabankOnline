<%--
  Created by IntelliJ IDEA.
  User: ilyamikheev
  Date: 14.09.18
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@include file="/WEB-INF/views/page_members/header.jsp"%>

<div class = money-transaction-container>

    <div class="money-transaction-conteiner__item">
        <div class="item__name">Между своими счетами</div>
    </div>

    <div class="money-transaction-conteiner__item">
        <div class="item__name">Клиенту банка</div>
        <div class="item__subname">На карту или счёт</div>
    </div>

    <div class="money-transaction-container__item">
        <div class="item__name">На карту в другой банк</div>
        <div class="item__subname">По номеру телефона или карты</div>
    </div>

    <div class="money-transaction-container__item">
        <div class="item__name">На счёт в другой банк</div>
    </div>

    <div class="money-transaction-container__item">
        <div class="item__name">Запросы денег</div>
    </div>

</div>


<%@include file="/WEB-INF/views/page_members/footer.jsp"%>

</body>
</html>
