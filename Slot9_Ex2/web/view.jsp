<%-- 
    Document   : view
    Created on : Oct 3, 2024, 8:45:02 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page</title>
    </head>
    <body>
        <form action="check" method="POST">
            Enter number: <input type="text" name="number" value="${number}"/>
            <input type="submit" value="Check"/>
        </form>       
        <p style="color:red">${error}</p>
        <p>${msgChan}</p>
        <p>${msgLe}</p>
        <p>${msgHoanHao}</p>
        <p>${msgNgTo}</p>

    </body>
</html>
