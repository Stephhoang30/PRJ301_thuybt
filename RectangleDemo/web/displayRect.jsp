<%-- 
    Document   : displayRect
    Created on : Sep 11, 2024, 12:01:24 AM
    Author     : stephhoang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <canvas id="myCanvas" width="500" height="500" style="border:1px solid grey"></canvas>
        <script>
            const c = document.getElementById("myCanvas");
            const ctx = c.getContext("2d");
            <c:forEach items="${rects}" var="r">
                <c:if test="${r.blue ge 200}">
                ctx.fillStyle = "rgb(${r.red},${r.green},${r.blue})";
                ctx.fillRect(${r.x},${r.y},${r.w},${r.h});
                ctx.beginPath();
                ctx.rect(${r.x},${r.y},${r.w},${r.h});
                ctx.stroke();
                </c:if>
            </c:forEach>
        </script>
    </body>
</html>
