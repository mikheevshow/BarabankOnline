<%--
  Created by IntelliJ IDEA.
  User: ilyamikheev
  Date: 17.09.18
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Barabånk - перевод средств</title>
    <%@include file="/WEB-INF/views/page_members/styles.jsp"%>

</head>
<body>

<%@include file="/WEB-INF/views/page_members/header.jsp" %>

<div class="content">

    Перевод на счёт в другой банк

    <form class="registration-form" action="/money-transactions/outer-bank-transactions" method="post">

        <div>
            <label>Счёт списания:<star>*</star></label>
            <%--<input class="input" name="reciver_account" placeholder="Номер счёта">--%>
        </div>

        <div>
            <label>Доступный лимит: {$balance}</label>
        </div>

        <div>
            <label>Номер счёта получтателя:<star>*</star></label>
            <input class="input" name="reciver_account" placeholder="Номер счёта">
        </div>

        <div>
            <label>Сумма:<star>*</star></label>
            <input class="input" name="sum" placeholder="Сумма">
        </div>

        <button class="regular-button green-button" type="submit" name="submit">Перевод</button>
    </form>

</div>

<%@include file="/WEB-INF/views/page_members/footer.jsp" %>


</body>
</html>
