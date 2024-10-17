<%-- 
    Document   : login
    Created on : Oct 11, 2024, 9:44:38 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>10_HoangCongThanh</title>
    </head>
    <body style="margin-left: 3cm">
        <h1>Admin Login</h1>
        <br/>
        <form action="login" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Username:</td>
                        <td>
                            <input type="text" name="username" placeholder="enter username" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td>
                            <input type="password" name="password" placeholder="enter password" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Login"/>
                        </td>
                        <td>                     
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <p style="color:red">${error}</p>
        <p style="color:green">${success}</p>

    </body>
</html>
