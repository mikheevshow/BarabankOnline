<%--
  Created by IntelliJ IDEA.
  User: ilyamikheev
  Date: 17.08.18
  Time: 3:11
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Barabånk - личный кабинет</title>
    <%@include file="/WEB-INF/views/page_members/styles.jsp"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="WEB-INF/resource/js/offer_card_window.js"></script>
    <script src="WEB-INF/resource/js/transaction_window.js"></script>

</head>
<body>

<%@include file="/WEB-INF/views/page_members/header.jsp"%>

<div class = "container-account">


    <div class = "buttons-container">

        <div class = "create-transaction-button button-type-one">
            Перевод
        </div>

        <div class = "order-debit-card-button button-type-one">
            Оформить карту
        </div>

        <div class=" replenish-funds-button button-type-one">
            Пополнить
        </div>

    </div>


    <div class = "account-info-container">

        <div class="account-info-container__info">

            <div class = "account-info-container__h1">
                Информация о пользователе
            </div>

            <div class = "informtion-line">
                ФИО: ${accountHolderName}
            </div>

            <div class = "informtion-line">
                Дата рождения: ${birthDate}
            </div>

            <div class = "informtion-line">
                Телефон: ${phone}
            </div>

        </div>

        <div class = "account-info-container__info">
            <div class = "account-info-container__h1">
                Информация о счетах
            </div>

            <div class = "informtion-line">
                Номер счета: ${accNum}
            </div>

            <div class = "informtion-line">
                Карта
            </div>

            <div class = "informtion-line">
                Баланс: ${balance}
            </div>

            <div class = "informtion-line">
                Овердрафт: ${overdraft}
            </div>

            <div class = "get-account-info-button">
                Получить выписку по счету
            </div>

        </div>

        <div class = "account-info-container__transactions">
            <div class = "account-info-container__h1">
                Информация о переводах
            </div>
            <table class="transactions-list">

            </table>
        </div>
    </div>
</div>



<%@include file="/WEB-INF/views/page_members/footer.jsp"%>

</body>
</html>
