<%-- 
    Document   : index
    Created on : 13-jul-2011, 14:25:08
    Author     : P.Odenhoven
--%>

<%@page   contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Developer Survey</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>Welcome To The Introduction Of web Development</h1>
        <h1>Let's do some serious CRUD-ing: </h1>

        <table>
            <tr>
            <form method="post" action="CreateUser">      
                <td> Create user<td>
                <td><input type="submit" value="Create User" /></td>
            </form>
        </tr>
        <tr>
        <form method="post" action="ListAllUser">      
            <td> Read User part I : List All<td>
            <td><input type="submit" value="List All Users"/></td>
        </form>
    </tr>
    <tr>
    <form method="post" action="ReadUser">      
        <td> Read user part II: Search by Last Name<td>
        <td><input type="submit" value="Search User by Name"/></td>
    </form>
</tr>  
<tr>
<form method="post" action="ReadUserByID">      
    <td> Read user part III: Search by ID<td>
    <td><input type="submit" value="Search User by ID" /></td>
</form>
</tr>  
<tr>
<form method="post" action="ReadUserToUpdate">      
    <td> Update user<td>
    <td><input type="submit" value="Update User"/></td>
</form>
</tr>
<tr>
<form method="post" action="ReadUserToDelete">      
    <td> Delete user<td>
    <td><input type="submit" value="Delete User" /></td>
</form>
</tr>

</table>
</html>
