<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My JSP Page</title>
</head>
<body>
    <h1>Is there any actor that doesn't play in any film:</h1>
    <c:out value="${hasActorWithNoFilms}" />
</body>
</html>