<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : list.jsp
    Created on : Oct 3, 2024, 4:32:20 PM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Page</title>
    </head>
    <body>
        <form action='student?action=searchByMajor' method='POST'>
            Select student's major:
            <select name="option">
                <option value=''>All</option>
                <c:forEach items="${listMajor}" var="major">
                    <option value='${major}' ${value == major ? "selected" : ""}>${major}</option>
                </c:forEach>
            </select>
            <input type='submit' value='Search'/>
        </form>
        <br/>
        <table border="1">
            <tbody>
                <tr>
                    <td>RollNo</td>
                    <td>Major</td>
                    <td>FullName</td>
                    <td>City</td>
                    <td>Gender</td>
                </tr>
                <c:forEach items="${listStudentByMajor}" var="stu">
                    <tr>
                        <td>${stu.getRollNo()}</td>
                        <td>${stu.getMajor()}</td>
                        <td>${stu.getFullName()}</td>
                        <td>${stu.getCity()}</td>
                        <td>${stu.isGender() == true ? "Male" : "Female"}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        <form action="add" method='GET'>
            <input type='submit' value='Add new'/>
        </form>

    </body>
</html>
