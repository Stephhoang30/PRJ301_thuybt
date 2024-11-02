<%-- 
    Document   : show
    Created on : Aug 8, 2024, 3:20:00 PM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        Choose an option to filter: 
        <select name="option" onchange="filter(this)"> 
            <option value="-1">All Departure places</option>
            <c:forEach items="${listDe}" var="de">                            
                <option value="${de.getDepartPlaceID()}" ${chosenDep == de.getDepartPlaceID()?"selected":""}>
                    ${de.getDepartPlaceName()}</option>
            </c:forEach>
        </select>

        <form action="show" method="">            
            <table border="1">
                <thead>
                    <tr>
                        <th>BoatID</th>
                        <th>BoatName</th> . 
                        <th>Seat</th>
                        <th>Booked</th>
                        <th>DepartPlace Name</th>
                        <th>Ticket Type</th>
                        <th>Is full?</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listBoats}" var="b">
                        <tr>
                            <td>${b.getBoatID()}</td>
                            <td>${b.getBoatName()}</td>
                            <td>${b.getSeat()}</td>
                            <td>${b.getBooked()}</td>
                            <td>${b.getDepartPlaceName()}</td>
                            <td>${b.getTicketName()}</td>
                            <td>${b.getSeat() == b.getBooked()?"X":""}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </form>
        
        <script>
             function filter(param){
                window.location = "show?depID=" + param.value;
             }
        </script>
    </body>
</html>
