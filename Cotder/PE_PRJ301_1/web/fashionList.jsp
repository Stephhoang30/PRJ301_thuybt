<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Welcome ${user.getFullName()}</h1>    
        <a href="MainController?action=logout">Log out</a>
    </body>
</html>
