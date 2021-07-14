
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Journal</title>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="grades">Oceny</a></li>
            </ul>
        </nav>
    </header>
<main>
    <h3>Wybierz datę listy:</h3>
    <form method="get" action="list">
        <select name="date">
            <c:forEach var="date" items="${dates}">
            <option value="${date}">${date}</option>
            </c:forEach>
        </select>
        <button type="submit">Wyświetl</button>
    </form>
</main>
</body>
</html>
