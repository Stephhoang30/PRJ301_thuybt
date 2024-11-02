<%-- 
    Document   : MyExam
    Created on : Sep 27, 2024, 8:27:55 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Exam</title>
    </head>
    <body>
        <form action="count" method="POST">
        <table border="0">          
            <tbody>
                <tr>
                    <td>Enter an integer n: </td>
                    <td>
                        <input type="text" name="number" value="${number}"/>
                    </td>
                </tr>
                <tr>
                    <td>Result: </td>
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
