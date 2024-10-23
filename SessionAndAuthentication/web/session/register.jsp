<%-- 
    Document   : register
    Created on : Oct 11, 2024, 9:44:48 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>10_HoangCongThanh</title>
    </head>
    <body style="margin-left: 3cm; margin-top: 2cm">
        <h1>Register Admin</h1>

        <form action="register" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Username:</td>
                        <td>
                            <input type="text" name="username" placeholder="enter username" value="${username}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td>
                            <input type="password" name="password" placeholder="enter password"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Confirm Password:</td>
                        <td>
                            <input type="password" name="confirm_password" placeholder="enter password"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Register Now"/>
                        </td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <p style="color:red">${error}</p>
    </body>
</html>
