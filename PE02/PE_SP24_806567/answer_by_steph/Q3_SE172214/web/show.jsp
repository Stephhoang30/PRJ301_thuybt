<%-- 
    Document   : show
    Created on : Jul 31, 2024, 3:46:37 PM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>LIST OF CODES</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listCoach}" var="co">
                    <tr>
                        <td>
                            <a href="details?id=${co.getCoachID()}">${co.getCoachID()}</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="details?id=${coach.getCoachID()}" method="POST">
            <table>
                <tr>
                    <td>Code:</td>
                    <td>
                        <input type="text" value="${coach.getCoachID()}"/>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td>
                        <input type="text" value="${coach.getCoachName()}"/>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Position:</td>
                    <td>
                        <input type="text" value="${coach.getPosition()}"/>
                    </td>
                    <td>
                        <input type="submit" value="DELETE"/>
                    </td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td>
                        <input type="text" value="${coach.getSalary()}"/>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Team:</td>
                    <td>
                        <c:forEach items="${listTeam}" var="team">
                            <c:if test="${coach.getTeamID() == team.getTeamID()}">
                                <input type="text" value="${team.getTeamName()}"/>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
