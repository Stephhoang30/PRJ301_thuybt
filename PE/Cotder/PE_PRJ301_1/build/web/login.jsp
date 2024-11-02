<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
        <form action="MainController">
            <input type='text' name='action' value='login' style='display: none'/>
            <table border="0">
                <tbody>
                    <tr>
                        <td>UserID</td>
                        <td>
                            <input type="text" name="userID" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input type="password" name="password" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>

                        </td>
                        <td>
                            <input type="submit" value="Login" />
                        </td>
                    </tr>
                <br/>
                </tbody>
            </table>

        </form>
        <div style='color: red'>${error}</div>
    </body>

</html>

