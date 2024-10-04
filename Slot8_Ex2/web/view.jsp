<%-- 
    Document   : view
    Created on : Oct 2, 2024, 11:22:13 AM
    Author     : stephhoang
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roll Page</title>
    </head>
    <body>
        <h1>HE172214</h1>
        <br/>
        <form action="getfirst" method="POST">
            Get first<input type="text" name="num" value="${num}"/>letter(s) 
            <br/>
            <input type="submit" value="Get"/> 
            <br/> <br/>
            ${result}
        </form>
    </body>
</html>
