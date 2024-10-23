<%-- 
    Document   : Info
    Created on : Oct 22, 2024, 11:41:41 PM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Profile page</h1>
        <h3>
            Username:${sessionScope.account.username}<br/>
            <c:if test="${sessionScope.account.role==1}">
                CHÀO MỪNG BẠN ĐẾN VỚI KÊNH BÁN HÀNG!
            </c:if>
            <c:if test="${sessionScope.account.role==2}">
                CHÀO MỪNG BẠN KHÁCH HÀNG!
            </c:if>
        </h3>
    </body>
</html>
