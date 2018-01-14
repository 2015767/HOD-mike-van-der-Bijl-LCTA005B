<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Gebruikers</title>
        <link href="<c:url value="/resources/style.css" />" rel="stylesheet" >
    </head>
    <body>
        <h2>Gebruikers</h2>
        <c:choose>
            <c:when test="${roleList.size() != 0}">
                <!-- Wanneer er gebruikers opgeslagen zijn, worden ze hier getoond -->
                <table class="roleList">
                    <tr>
                        <td>
                            <strong>id</strong>
                        </td>
                        <td>
                            <strong>Naam</strong>
                        </td>
                    </tr>
                    <c:forEach var="role" items="${roleList}">
                        <!-- Per gebruiker wordt nu een rij aangemaakt met daarin zijn gegevens -->
                        <tr>
                            <td>${role.id}</td>
                            <td>${role.name}</td>
                            
                            <td><a href="${pageContext.request.contextPath}/role/edit/${role.id}">Wijzig</a> </td>
                            <td><a href="${pageContext.request.contextPath}/role/remove/${role.id}">Verwijder</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <!-- Als er geen gebruikers zijn, wordt deze melding getoond -->
                Er zijn geen rollen gevonden.
            </c:otherwise>
        </c:choose>
        <p>
            <a href="${pageContext.request.contextPath}/role/add">Maak nieuwe role aan</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/index">Terug naar de index</a>
        </p>
    </body>
</html>
