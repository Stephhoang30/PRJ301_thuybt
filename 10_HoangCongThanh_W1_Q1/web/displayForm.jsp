<%-- 
    Document   : displayForm
    Created on : Oct 9, 2024, 10:41:41 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>10_HoangCongThanh_Q1</title>
    </head>
    <body>
        <form action="Thanh1" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>First Number:</td>
                        <td>
                            <input type="text" name="first" value="<%= request.getAttribute("firstValue") != null ? request.getAttribute("firstValue") : "" %>"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Second Number:</td>
                        <td>
                            <input type="text" name="second" value="${secondValue}"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Sum" name="action"/>
                        </td>
                        <td>
                            <input type="submit" value="Substract" name="action"/>
                        </td>
                        <td>
                            <input type="submit" value="Product" name="action"/>
                            <input type="submit" value="Division" name="action"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>

        <p style="color:red">${error}</p>       
        <p>${result}</p>

    </body>
</html>
