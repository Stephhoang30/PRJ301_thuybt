<%-- 
    Document   : menu
    Created on : Oct 22, 2024, 11:34:58 PM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
    </head>
    <body>
        <a href="userTask">
            User Task
        </a>
        ||
        <a href="sellerTask">
            Seller Task
        </a>
        ||
    <c:if test="${sessionScope.account!=null}">
        <a href="info">
            User Info
        </a>
        ||
        <a href="logout">
            Logout
        </a>
        &nbsp;&nbsp;&nbsp;
        <span style="color:red">[ ${sessionScope.account.username} ]</span>
        
    </c:if>
        
    <c:if test="${sessionScope.account==null}">        
        <a href="login">
            Login
        </a>
    </c:if>
</body>
</html>
