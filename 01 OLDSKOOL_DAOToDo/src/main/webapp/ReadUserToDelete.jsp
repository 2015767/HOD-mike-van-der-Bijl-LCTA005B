<%-- 
    Document   : EditUser
    Created on : 20-sep-2012, 11:09:05
    Author     : P.Odenhoven
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update or Delete User</title>
    </head>
    <body>
        <h1>This is the D-part of CRUD: DELETE</h1>
        <h2>IN ORDER TO UPDATE or DELETE, YOU'LL FIRST HAVE TO FIND THE USER </h2>
        <form  method="post" action="SearchUserIdToDelete"><table border="0">

                <tbody>
                    <tr>
                        <td>User ID</td>
                        <td><input type="text" name="userId" value="" /></td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td><input type="submit" value="Search by ID" /></td>
                    </tr>
                </tbody>
            </table>

        </form>

    </body>
</html>
