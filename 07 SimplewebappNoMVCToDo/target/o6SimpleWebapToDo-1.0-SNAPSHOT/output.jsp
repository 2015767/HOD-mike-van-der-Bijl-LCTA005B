<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Welcome To The Introduction Of web Development</h1>
        <p>Please enter your name <%= request.getParameter("firstName")%> <%= request.getParameter("lastName")%></p>
        <form action="output.jsp"><table border="0">

                <tbody>
                    <tr>
                        <td>First Name :</td>
                        <td><input type="text" name="firstName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name :</td>
                        <td><input type="text" name="lastName" value="" /></td>
                    </tr>

                <td><input type="submit" value="Submit" /></td>
                </tr>
                </tbody>
            </table>
        </form> 
    </body>
</html>
