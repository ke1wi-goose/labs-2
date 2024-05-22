<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Movie With Most Actors</title>
</head>
<body>
    <h1>Movie With Most Actors</h1>

    <c:if test="${not empty movieWithMostActors}">
        <p>Title: <c:out value="${movieWithMostActors.title}"/></p>
        <h2>Actors</h2>
        <ul>
            <c:forEach var="actor" items="${movieWithMostActors.actors}">
                <li><c:out value="${actor.name}"/></li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty movieWithMostActors}">
        <p>No movie found.</p>
    </c:if>

    <a href="index.jsp">Back to Main Page</a>
</body>
</html>
