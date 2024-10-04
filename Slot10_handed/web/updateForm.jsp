<%-- 
    Document   : updateForm
    Created on : Oct 4, 2024, 9:18:13 PM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Form</title>
    </head>
    <body>
        <h1>Currency Exchange Rates</h1>
        <button onclick="window.location.href = 'home'">Currency List</button>
        <button>Hello ${username}</button>
        <button onclick="window.location.href = 'logout'">Logout</button>

        <h2>Update Currency Rate</h2>
        <p style="color:red">${error}</p>
        <form action="update" method="POST">
            Code:<br/>
            <input type="text" name="code" readonly="" value="${c.getCode()}"/><br/>
            Name:<br/>
            <input type="text" name="name" value="${c.getName()}"/><br/>
            Description:<br/>
            <input type="text" name="des" value="${c.getDescription()}"/><br/>
            Rate:<br/>
            <input type="text" name="rate" value="${c.getRate()}"/><br/>
            <input type="submit" value="Update Rate"/>
        </form>
    </body>
</html>
