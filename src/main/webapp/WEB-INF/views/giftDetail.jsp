<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.12.2024
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Детали подарка</title>
</head>
<body>
<h1>Детали подарка</h1>
<p><strong>Название подарка:</strong> ${gift.name}</p>
<p><strong>Даритель:</strong> ${gift.giverName}</p>
<p><strong>Получатель:</strong> ${gift.receiverName}</p>
<p><strong>Дата вручения:</strong> ${gift.deliveryDate}</p>
<br/>
<a href="gifts">Назад к списку подарков</a>
</body>
</html>


