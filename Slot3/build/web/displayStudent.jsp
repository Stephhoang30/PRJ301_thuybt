<%-- 
    Document   : displayStudent
    Created on : Sep 11, 2024, 12:53:16 PM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student View</title>
    </head>
    <body>
        <form action="student" method="POST">
            <table border="0">           
                <tbody>
                    <tr>
                        <td>Nhap vao Ho va ten dem: </td>
                        <td>
                            <input type="text" name="lastName"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Nhap vao Ten: </td>
                        <td>
                            <input type="text" name="firstName"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Gioi tinh: </td>
                        <td>
                            Nam: <input type="radio" name="gioitinh" value="male" />
                            Nu: <input type="radio" name="gioitinh" value="female" />
                        </td>
                    </tr>
                    <tr>
                        <td>Mon hoc: </td>
                        <td>
                            <select name="subject">
                                <option></option>
                                <option></option>
                                <option></option>
                                <option></option>
                                <option></option>
                                <option></option>
                                <option></option>
                                <option></option>
                                <option></option>
                                <option></option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Diem: </td>
                        <td>
                            <input type="text" name="score"/>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
