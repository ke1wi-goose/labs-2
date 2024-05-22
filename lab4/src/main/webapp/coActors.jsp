<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Co-Actors</title>
</head>
<body>
    <h1>Co-Actors of <c:out value="${actorName}"/></h1>
    
    <c:if test="${not empty coActors}">
        <ul>
            <c:forEach var="actor" items="${coActors}">
                <li><c:out value="${actor.name}"/></li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty coActors}">
        <p>No co-actors found.</p>
    </c:if>
    
    <a href="index.jsp">Back to Main Page</a>
</body>
</html>
