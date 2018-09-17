<%--
  Created by IntelliJ IDEA.
  User: ilyamikheev
  Date: 17.09.18
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Barabånk - перевод средств</title>
</head>
<body>

<div class="content">
    <div class = "create-transaction-button button-type-one">
        <a href="/money-transactions/self-transactions">Перевод между своими счетами</a>
    </div>

    <div class = "create-transaction-button button-type-one">
        <a href="/money-transactions/self-bank-transactions">Перевод на счет клиента банка</a>
    </div>

    <div class = "create-transaction-button button-type-one">
        <a href="/money-transactions/outer-bank-transactions">Перевод на счёт в другой банк</a>
    </div>
</div>

</body>
</html>
