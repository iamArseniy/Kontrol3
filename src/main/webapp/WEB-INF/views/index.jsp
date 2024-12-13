<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.12.2024
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Список подарков</title>
</head>
<body>
<h1>Список подарков</h1>
<ul>
    <c:forEach var="gift" items="${gifts}">
        <li>
            <a href="<c:url value="/giftDetail?id=${gift.id}"/>">
                    ${gift.name} (от ${gift.giverName} для ${gift.receiverName})
            </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
