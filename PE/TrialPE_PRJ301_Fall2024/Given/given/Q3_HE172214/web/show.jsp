<%-- 
    Document   : show
    Created on : Sep 27, 2024, 9:31:46 AM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instructors Page</title>
    </head>
    <body>
        <div>
            List of Subjects: 
            <select name="subject">
                <option>All subjects</option>
                <c:forEach items="${listSubjects}" var="s">
                    <option value="${s.getSubjectID()}">${s.getSubjectName()}</option>             
                </c:forEach>
                
            </select>
        </div>
        <br/>
        <div>
            <p>List of Instructors:</p>     
            <table border="1">
                <tbody>
                    <tr>
                        <td>Code</td>
                        <td>Name</td>
                        <td>Date of birth</td>
                        <td>Gender</td>
                        <td>Subject</td>
                        <td>Select</td>
                    </tr>

                    <c:forEach items="${listInstructors}" var="ins">
                        <tr>
                            <td>${ins.getInstructorID()}</td>
                            <td>${ins.getInstructorName()}</td>
                            <td>${ins.getBirthDate()}</td>
                            <td>${ins.getGender() == 1 ? "Male" : "Female"}</td>
                            <td>
                                <c:forEach items="${listSubjects}" var="s">
                                    <c:if test="${ins.getSubjectID() == s.getSubjectID()}">
                                        ${s.getSubjectName()}
                                    </c:if> 
                                </c:forEach>
                            </td>
                            <td>
                                <a href="#">Select</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </body>
</html>
