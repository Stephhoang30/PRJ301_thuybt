<%-- 
    Document   : circle2
    Created on : Oct 2, 2024, 10:57:30 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculate Circle Area 2</title>
    </head>
    <body>
        <h1>Calculate Circle Area 2</h1>
        <form action="cal3" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>
                            Enter radius:
                        </td>
                        <td>
                            <input type="text" name="radius" value="${radius}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit"/>
                        </td>
                        <td>
                            ${msg}
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
