<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Actors Without Movies</title>
</head>
<body>
    <h1>Actors Without Movies</h1>
    
    <c:if test="${not empty actorsWithoutMovies}">
        <ul>
            <c:forEach var="actor" items="${actorsWithoutMovies}">
                <li><c:out value="${actor.name}"/></li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty actorsWithoutMovies}">
        <p>No actors found.</p>
    </c:if>
    
    <a href="index.jsp">Back to Main Page</a>
</body>
</html>
