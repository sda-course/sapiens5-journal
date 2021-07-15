<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <td>${fn:toUpperCase(fn:trim(name))}</td>
        </tr>
    </c:if>
    <c:if test="${status.index % 2 != 0}">
        <tr style="color: blue;">
            <td>${status.index + 1}</td>
            <td>${fn:toUpperCase(fn:trim(name))}</td>
        </tr>
    </c:if>
</c:forEach>
</table>
<h3>Liczba obecnych: ${count}</h3>
<h3>Procent obecnych:
    <fmt:formatNumber value="${count / 10}" type="percent" maxFractionDigits="1" minFractionDigits="1"/> </h3>
</div>
</body>
</html>
