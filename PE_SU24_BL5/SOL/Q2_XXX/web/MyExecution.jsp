<%-- 
    Document   : MyExecution
    Created on : Aug 31, 2024, 3:33:57 PM
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
        <form action="load" method="get">
            <table>
                <tbody>
                    <tr>
                        <td>Enter a String (str): </td>
                        <td><input type="text" name="str" value="${str}"></td>
                    </tr>
                    <tr>
                        <td>Enter an integer (n):</td>
                        <td><input type="text" name="n" value="${n}"><!-- comment --></td>
                    </tr>
                    <tr>
                        <td>Result: </td>
                        <td><input type="text" name="n" value="${result}"></td>
                    </tr>
                    <tr>
                        <td><button type="submit">SUB FIRST</button></td>
                        <td>${exist}</td>
                    </tr>
                </tbody>
            </table>
        </form>
                    ${mess}
        <table border="1">
            <thead>
                <tr>
                    <th>String str</th>
                    <th>Index n</th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listS}" var="o">
                <tr>
                    <td>${o.getStr()}</td>
                    <td>${o.getIndex()}</td>
                    <td>${o.getResult()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</body>
</html>
