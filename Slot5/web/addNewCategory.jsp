    <%-- 
    Document   : addNewCategory
    Created on : Sep 18, 2024, 12:34:06 PM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Category</title>
    </head>
    <body>
        <h1> Add New Category </h1>

        <form action="add" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Category Name:</td>
                        <td>
                            <input type="text" name="name" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Category Describe: </td>
                        <td>
                            <input type="text" name="des" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Add"/>
                            <input type="reset" value="Reset"/>
                        </td>
                    </tr>   
                    <tr>
                        <td></td>
                        <td>
                            <p style="color: red;">${error}</p>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        
    </body>
</html>
