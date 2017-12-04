<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List All Users</title>
    </head>
    <body>
        <h1>This is the R-part III of CRUD: LIST THE UNIQUE USER SELECTED BY ID </h1>

        <table border="1">
            <tr>
                <td><strong>User ID</strong></td>
                <td><strong>First name</strong></td>
                <td><strong>Last name</strong></td>
                <td><strong>Email address</strong></td>

            </tr>

            <tr>
                <td>${requestScope.userdata.userId}</td>
                <td>${requestScope.userdata.firstName}</td>
                <td>${requestScope.userdata.lastName}</td>
                <td>${requestScope.userdata.eMail}</td>
            </tr>

        </table>
        <br>                
        <form method="post" action="ControllerServlet">                    
            <input type="submit" value="Back to menu"/>
        </form>
    </body>
</html>
