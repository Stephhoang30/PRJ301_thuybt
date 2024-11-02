<%-- 
    Document   : tinhtong
    Created on : Jul 17, 2024, 5:34:32 AM
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
        <form action="tong" method="post">
            Number 1:
            <input type="text" name="number1"/>
            <br/> <br/>
            Number 2:
            <input type="text" name="number2"/>
            <br/> <br/>        
            <button type="submit">Tinh tong</button>
          
        </form>
        <br/> <br/>    
        
        Ket qua: ${total}
        
    </body>
</html>
