<%-- 
    Document   : CreateUser
    Created on : 20-sep-2012, 11:08:50
    Author     : P.Odenhoven
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <body>
        <h1>This is the C-part of CRUD: CREATE</h1>
        <form  method="post" action="InsertUser">
            <table border="0">
                <tr>
                    <td>First name:</td>
                    <td><input type="text" name="firstName" value="" /></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><input type="text" name="lastName" value="" /></td>
                </tr>
                <tr>
                    <td>Email Address:</td>
                    <td><input type="text" name="eMail" value="" /></td>
                </tr>
                <tr></tr>
                <tr>
                    <td><input type="submit" value="Save user" /></td>
                </tr>
            </table>

        </form>

    </body>
</html>
