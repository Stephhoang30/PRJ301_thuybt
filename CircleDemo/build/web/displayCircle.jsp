<%-- 
    Document   : displayCircle
    Created on : Sep 10, 2024, 10:02:18 PM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList" %>
<%@page import ="model.Circle" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Page</title>
        <% 
            ArrayList<Circle> listCircle = (ArrayList<Circle>)request.getAttribute("listCircle");
        %>
    </head>
    <body>
        <canvas id = "mycanvas" width="500" height="500" style="border: 1px solid gray" ></canvas>
        <script>
            const c = document.getElementById("mycanvas");
            const ctx = c.getContext("2d");
            <% 
            for(Circle circle : listCircle){
            %>
            ctx.beginPath();
            ctx.arc(<%=circle.getX()%>, <%= circle.getY()%>, <%= circle.getR()%>, 0, 2 * Math.PI);
            ctx.stroke();
            <%}%>
        </script>
    </body>
</html>
