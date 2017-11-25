<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, tr, td { border: 1px solid #000000;}
        </style>
    </head>
    <body>
        <table style="border: 1px solid #000000;">
            <tr><td>${employee[0].id}</td><td>${employee[0].name}</td><td>${employee[0].role}</td></tr>
            <tr><td>${employee[1].id}</td><td>${employee[1].name}</td><td>${employee[1].role}</td></tr>
        </table>
    </body>
</html>
