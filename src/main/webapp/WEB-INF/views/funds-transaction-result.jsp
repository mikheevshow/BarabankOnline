<%--
  Created by IntelliJ IDEA.
  User: ilyamikheev
  Date: 17.09.18
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Barabånk - перевод стредств</title>
    <%@include file="/WEB-INF/views/page_members/styles.jsp"%>

</head>
<body>

<%@include file="/WEB-INF/views/page_members/header.jsp" %>

<div class="content">
    <div class="transaction-result-message">${transactionResultMessage}</div>
    <div class="regular-button"><a href ='/account'>Личный кабинет</a></div>
</div>

<%@include file="/WEB-INF/views/page_members/footer.jsp" %>

</body>
</html>
