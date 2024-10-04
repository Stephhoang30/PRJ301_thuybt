<%-- 
    Document   : login
    Created on : Oct 4, 2024, 9:17:58 PM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <p style="color:red">${error}</p>
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>Username</td>
                    <td>
                        <input type="text" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <input type="password" name="password"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Login"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
