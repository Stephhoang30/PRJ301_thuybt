<%-- 
    Document   : Home
    Created on : Aug 31, 2024, 4:00:51 PM
    Author     : Tra Pham
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
        <form action="sort" method="post">
            <table >
                <tbody>
                    <tr>
                        <td>Sort by Type name: </td>
                        <td> <input type="radio" name="typeName" value="asc" ${typeName1=="asc"?"checked":""}> Ascending <!-- comment -->
                            <input type="radio" name="typeName" value="desc" ${typeName1=="desc"?"checked":""}> Descending <!-- comment --></td>
                    </tr>
                    <tr>
                        <td>Then by Index</td>
                        <td> <input type="radio" name="typeIndex" value="asc" ${typeIndex1=="asc"?"checked":""}> Ascending <!-- comment -->
                            <input type="radio" name="typeIndex" value="desc"${typeIndex1=="desc"?"checked":""}> Descending <!-- comment --></td>
                    </tr>
                    <tr>
                        <td><button type="submit">SORT</button></td>
                    </tr>
                </tbody>
            </table>
        </form>
        List of executions:
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>String</th>
                    <th>Index</th>
                    <th>Type</th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listS}" var="o">
                    <tr>
                        <td>${o.getExecutionID()}</td>
                        <td>${o.getInputString()}</td>
                        <td>${o.getSubIndex()}</td>
                        <td>${o.getTypeName()}</td>
                        <td>${o.getResult()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
