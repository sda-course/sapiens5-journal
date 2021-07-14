<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista obecności</title>
</head>
<body>
<c:set var="count" scope="page" value="${list.size()}"/>
<h1>Lista obecności</h1>
<h2>Data: ${param.date}</h2>
<table>
    <tr>
        <th>nr</th>
        <th>imię</th>
    </tr>
<c:forEach var="name" items="${list}" varStatus="status">
    <c:if test="${status.index % 2 == 0}">
        <tr style="color: red;">
            <td>${status.index + 1}</td>
            <td>${name}</td>
        </tr>
    </c:if>
    <c:if test="${status.index % 2 != 0}">
        <tr style="color: blue;">
            <td>${status.index + 1}</td>
            <td>${name}</td>
        </tr>
    </c:if>
</c:forEach>
</table>
<h3>Liczba obecnych: ${count}</h3>
</div>
</body>
</html>
