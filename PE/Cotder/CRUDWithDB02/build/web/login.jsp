<%-- 
    Document   : login
    Created on : Jul 17, 2024, 9:33:53 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            Username
            <input type="text" name="username"/>
            <br/>
            Password
            <input type="password" name="password"/>
            <br/>
            <div style="color:red">${error}</div>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
