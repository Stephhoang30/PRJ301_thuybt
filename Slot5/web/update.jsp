<%-- 
    Document   : update
    Created on : Sep 18, 2024, 5:20:26 PM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <form action="update" method="POST">
            <input type="hidden" name="id" value="${c.getId()}"/>
            <table border="0">
                <tbody>
                    <tr>
                        <td>Category Name: </td>
                        <td>
                            <input type="text" name="name" value="${c.getName()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Category Describe: </td>
                        <td>
                            <input type="text" name="des" value="${c.getDescribe()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Update"/>
                        </td>
                    </tr>              
                </tbody>
            </table>

        </form>
    </body>
</html>
