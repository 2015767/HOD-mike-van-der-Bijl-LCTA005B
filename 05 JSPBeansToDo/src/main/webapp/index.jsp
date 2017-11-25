<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Employee</title>
    </head>
    <body>
        employee: ${employee.name} <br/> 
        city: ${employee.address.city} <Br>
        street: ${employee.address.streetName} <Br>
        number: ${employee.address.streetNumber} <Br>
        zipcode: ${employee.address.zipCode} <Br>
        state: ${employee.address.state} <Br>
        country: ${employee.address.country} <Br><br>
        
        capital: ${capitals[employee.address.country]} <Br>

    </body>
</html>
