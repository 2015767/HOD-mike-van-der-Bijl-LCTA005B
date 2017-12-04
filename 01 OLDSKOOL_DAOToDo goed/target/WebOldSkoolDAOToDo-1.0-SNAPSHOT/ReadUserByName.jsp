<%-- 
    Document   : ReadUser
    Created on : 20-sep-2012, 11:10:01
    Author     : P.Odenhoven
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read User</title>
    </head>
    <body>
        <h1>This is the R-part II of CRUD: SEARCH BY NAME</h1>
        <form  method="post" action="SearchUserLastName"><table border="0">

                <tbody>
                    <tr>
                        <td>Last name</td>
                        <td><input type="text" name="lastName" value="" /></td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td><input type="submit" value="Search by name" /></td>
                    </tr>
                </tbody>
            </table>

        </form>

    </body>
</html>
