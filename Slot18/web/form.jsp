<%-- 
    Document   : form
    Created on : Nov 1, 2024, 8:00:31 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculate Page</title>
    </head>
    <body>
        
        <form action="sum" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>a=</td>
                        <td>
                            <input type="text" name="a" value="${a}" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>b=</td>
                        <td>
                            <input type="text" name="b" value="${b}" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>c=</td>
                        <td>
                            <input type="text" value="${res}" readonly="" placeholder="Here is result"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Sum"/>
                        </td>
                        <td>
                            <span style="color:red">${error}</span>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
                        
    </body>
</html>
