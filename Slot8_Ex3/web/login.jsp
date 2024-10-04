<%-- 
    Document   : login
    Created on : Oct 2, 2024, 11:55:32 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>10-HoangCongThanh-Ex3</title>
    </head>
    <body>
        ${result}
        <form action="login" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td>
                            <input type="text" name="user"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input type="password" name="pass"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Login"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
