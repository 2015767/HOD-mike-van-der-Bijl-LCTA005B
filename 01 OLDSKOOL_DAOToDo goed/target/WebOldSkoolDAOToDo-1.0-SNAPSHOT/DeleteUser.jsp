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
        <title>Update User</title>
        <script type="text/javascript">

        </script>
    </head>
    <body>
        <h1>This is the D-part of CRUD: DELETE</h1>
        <h2>With a (small ) in line JavaScript for Confirmation ...</h2>
        <form  onsubmit="return confirm('Do you really want to submit the form?');" method="post" action="DeleteUser">
            <table border="0">
                <tr>
                    <td>User ID:</td>
                    <td>${requestScope.userdata.userId}
                        <input type=hidden name="userId" value="${requestScope.userdata.userId}"  />
                    </td>
                </tr>
                <tr>
                    <td>First name:</td>
                    <td><input type="text" name="firstName" value="${requestScope.userdata.firstName}" /></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><input type="text" name="lastName" value="${requestScope.userdata.lastName}" /></td>
                </tr>
                <tr>
                    <td>Email Address:</td>
                    <td><input type="text" name="eMail" value="${requestScope.userdata.eMail}" /></td>
                </tr>
                <tr></tr>
                <tr>

                    <td><input type="submit"  value="Delete user" /></td>

                </tr>

            </table>
        </form>

    </body>
</html>
