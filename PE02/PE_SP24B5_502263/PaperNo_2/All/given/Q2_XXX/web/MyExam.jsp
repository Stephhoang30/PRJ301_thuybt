<%-- 
    Document   : MyExam
    Created on : Aug 6, 2024, 3:32:04 PM
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
        <form action="exe" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td colspan="2" style="text-align: center">TRAIN INFORMATION</td>
                    </tr>
                    <tr>
                        <td>Train code:</td>
                        <td>
                            <input type="text" name="code"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Train name:</td>
                        <td>
                            <input type="text" name="name"/>

                        </td>
                    </tr>
                    <tr>
                        <td>Seat number:</td>
                        <td>
                            <input type="text" name="seatNum"/>

                        </td>
                    </tr>
                    <tr>
                        <td>Booked:</td>
                        <td>
                            <input type="text" name="booked"/>

                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <input type="submit" value="BOOK"/>
                        </td>
                    </tr>
                </tbody>

            </table>

            <br/>
            
            ${error}
            
            <c:if test="${code != null}">
                Information of booked train
                <br/>
                
                ID:${code}               
                <br/>

                Name:${name}
                <br/>

                Seat:${seatNum}
                <br/>

                Book:${booked}
                <br/>

                Is full?${isFull}
            </c:if>

        </form>
    </body>
</html>
