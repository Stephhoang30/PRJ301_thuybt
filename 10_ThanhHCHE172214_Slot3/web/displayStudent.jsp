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
                            <input type="text" name="lastName" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Nhap vao Ten: </td>
                        <td>
                            <input type="text" name="firstName" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Gioi tinh: </td>
                        <td>
                            Nam:<input type="radio" name="gioitinh" value="male" />
                            Nu:<input type="radio" name="gioitinh" value="female" />
                        </td>
                    </tr>
                    <tr>
                        <td>Mon hoc: </td>
                        <td>
                            <select name="subject">
                                <option value="MAS291">MAS291</option>
                                <option value="JPD123">JPD123</option>
                                <option value="IOT102">IOT102</option>
                                <option value="PRJ301">PRJ301</option>
                                <option value="SWE201c">SWE201c</option>
                                <option value="SWP391">SWP391</option>
                                <option value="ITE302c">ITE302c</option>
                                <option value="SWR302">SWR302</option>
                                <option value="SWT301">SWT301</option>
                                <option value="PRN212">PRN212</option>
                            </select>

                        </td>
                    </tr>
                    <tr>
                        <td>Diem: </td>
                        <td>
                            <input type="number" name="score" min="0" max="10" step="0.1" required />
                        </td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Send"/>
                        </td>
                    </tr>

                </tbody>
            </table>
            
            
        </form>
    </body>
</html>
