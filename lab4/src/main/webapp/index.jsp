<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Movie Database</title>
</head>
<body>
    <h1>Movie Database</h1>
    
    <h2>All Movies</h2>
    <ul>
        <c:forEach var="movie" items="${movies}">
            <li><c:out value="${movie.title}"/></li>
        </c:forEach>
    </ul>
    
    <h2>All Actors</h2>
    <ul>
        <c:forEach var="actor" items="${actors}">
            <li><c:out value="${actor.name}"/></li>
        </c:forEach>
    </ul>
    
    <h2>Actions</h2>
    <ul>
        <li><a href="movieController?action=findActorsWithoutMovies">Find Actors Without Movies</a></li>
        <li>
            Find Co-Actors:
            <form action="movieController" method="get">
                <input type="hidden" name="action" value="findCoActors"/>
                Actor Name: <input type="text" name="actorName"/>
                <input type="submit" value="Find"/>
            </form>
        </li>
        <li><a href="movieController?action=findMovieWithMostActors">Find Movie With Most Actors</a></li>
    </ul>
</body>
</html>
