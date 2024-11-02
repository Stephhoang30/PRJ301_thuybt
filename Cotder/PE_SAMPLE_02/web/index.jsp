<%-- 
    Document   : index
    Created on : Jul 21, 2024, 8:56:19 AM
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
        <form action="count" method="post">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Enter an integer n:</td>
                        <td>
                            <input type="text" name="number" value="${kienhang1}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Result:</td>
                        <td>
                            <input type="text" value="${result}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="COUNT"/>
                        </td>
                        <td>
                            ${error}
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
