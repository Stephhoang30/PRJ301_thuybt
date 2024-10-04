<%-- 
    Document   : home
    Created on : Oct 4, 2024, 9:18:07 PM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Currency Exchange Rates</h1>
        <button onclick="window.location.href = 'home'">Currency List</button>
        <button>Hello ${username}</button>
        <button onclick="window.location.href = 'logout'">Logout</button>

        <form action="home?action=search" method="POST">
            Code: <input type="text" name="code" value="${code}"/>
            Name: <input type="text" name="name" value="${name}"/>
            <input type="submit" value="Search"/>           
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Rate</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>   
                <c:forEach items="${listCur}" var="c">
                    <tr>
                        <td>${c.getCode()}</td>
                        <td>${c.getName()}</td>
                        <td>${c.getDescription()}</td>
                        <td>${c.getRate()}</td>
                        <td>
                            <button onclick="window.location.href = 'update?code=${c.getCode()}'">Update</button>
                        </td>
                    </tr> 
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
