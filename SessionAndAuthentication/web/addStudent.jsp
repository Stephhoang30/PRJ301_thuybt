<%-- 
    Document   : addStudent
    Created on : Oct 18, 2024, 4:14:32 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="margin: 2cm">
        <h1>Add New Student</h1>
        <form action="check?action=add" method="post">
            <table border="1" cellpadding="5" cellspacing="0">
                <tr>
                    <td>ID:</td>
                    <td><input type="text" name="id" required></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td><input type="date" name="dob" required></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>
                        <input type="radio" name="gender" value="Male" required> Male
                        <input type="radio" name="gender" value="Female" required> Female
                    </td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Add Student">
                        <input type="reset" value="Reset">
                    </td>
                </tr>
            </table>
        </form>

    </body>
</html>
