<%-- 
    Document   : circle1
    Created on : Oct 2, 2024, 10:11:49 AM
    Author     : stephhoang
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Circle Area</title>
    </head>
    <body>
        <h1>Calculate Circle Area 1</h1>
        <form action="circle1.jsp">
            <table border="0">
                <tbody>
                    <tr>
                        <td>
                            Enter radius:
                        </td>
                        <td>
                            <input type="text" name="radius" value="<%= request.getParameter("radius") != null ? request.getParameter("radius") : "" %>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit"/>
                        </td>
                        <td>
                            <% 
                                String radiusStr = request.getParameter("radius");
                                if(radiusStr != null) {
                                    try {
                                        double radius = Double.parseDouble(radiusStr);
                                        if (radius < 0) {
                                            out.println("<p style='color:red;'> Error: Radius cannot be negative. Please enter a positive value. </p>");
                                        } else {
                                            double area = Math.PI * radius * radius;
                                            DecimalFormat df = new DecimalFormat("#.##");
                                            String formattedArea = df.format(area);
                                            out.println("<p> Area of the circle with radius " + radius + " is: " + formattedArea + "</p>");
                                        }
                                    } catch (NumberFormatException e) {
                                       out.println("<p style='color:red;'> Error: Invalid input. Please enter a valid number. </p>");
                                    }
                                }
                            %>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
