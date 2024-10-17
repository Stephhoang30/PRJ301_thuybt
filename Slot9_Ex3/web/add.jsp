<%-- 
    Document   : add
    Created on : Oct 3, 2024, 4:18:46 PM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Page</title>
    </head>
    <body>
        <h1>Enter the information of Student</h1>
        <br/>
        <form action="add" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Roll no</td>
                        <td>
                            <input type="text" name="roll" value="" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Major</td>
                        <td>
                            <select name="major" required>
                                <c:forEach items="${listMajor}" var="major">
                                    <option value='${major}' ${major == "Engineering" ? "selected" : ""}>${major}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Full name</td>
                        <td>
                            <input type="text" name="name" value="" required />
                        </td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td>
                            <input type="text" name="city" value="" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>
                            <input type="radio" name="gender" value="male" checked="checked" required />Male
                            <input type="radio" name="gender" value="female" required />Female
                        </td>
                    </tr>
                </tbody>
            </table>


            <input type="submit" value="Save"/>
            <button type="button" onclick="window.location.href = 'student';">Cancel</button>          
        </form>

        <c:if test="${not empty error}">
            <p style="color:red">${error}</p>
        </c:if>


    </body>
</html>
