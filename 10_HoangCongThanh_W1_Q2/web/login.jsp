<%-- 
    Document   : displayForm
    Created on : Oct 9, 2024, 11:10:17 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>10_HoangCongThanh_Q2</title>
    </head>
    
    <body style="margin-left: 3cm; margin-right: 2cm;">       
        <header style="background-color: grey;">
            <div>
                <h1>My Site</h1>
            </div>
            <div style="text-align: right;">
                <p>Hello</p>
                <p>Search <input type="text"/></p>
            </div>
        </header>


        <div style="text-align: center;">
            <a href="#">Home</a> | <a href="#">Product List</a> | <a href="#">My Account Info</a> | <a href="#">Login</a>
        </div>

        <div>
        <h2>Login Page</h2>
        <br/>
        <form action="Thanh2" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>User Name</td>
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
                        <td>Remember me</td>
                        <td>
                            <input type="checkbox" name="rememberMe" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit"/>
                            <a href="login.jsp">Cancel</a>
                        </td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </form>
        </div>
        
        <p style="color:red">${error}</p>
        
        <br/>

        <footer style="background-color: grey; padding: 10px; text-align: center;">
            <p>
                @Copyright 
                <input type="text" value="10_HoangCongThanh_Workshop1" readonly="" style="width: 300px;"/>
            </p>
        </footer>
        
    </body>
</html>
