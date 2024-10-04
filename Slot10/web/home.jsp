<%-- 
    Document   : home
    Created on : Oct 4, 2024, 4:20:45 PM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Currency Exchange Rates</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            .container {
                width: 50%;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #000;
            }
            .header {
                background-color: #f2f2f2;
                padding: 20px;
                text-align: center;
                font-size: 36px;
                font-weight: bold;
            }
            .form-group {
                margin: 10px 0;
            }
            label {
                display: block;
                margin-bottom: 5px;
            }
            input[type="text"] {
                padding: 8px;
                border: 1px solid #000;
                border-radius: 4px;
            }
            .btn {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            .btn:hover {
                background-color: #45a049;
            }
            .nav {
                margin-bottom: 20px;
            }
            .nav a {
                margin-right: 15px;
                text-decoration: none;
                color: #000;
            }
            .nav a:hover {
                text-decoration: underline;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                padding: 8px;
                text-align: left;
            }
            /* Flexbox styling for the form row */
            .form-row {
                display: flex;
                align-items: center;
                gap: 15px; /* space between items */
            }
            .form-row input {
                width: 200px; /* Adjust width to your preference */
            }
            /* Ensuring search button is vertically centered */
            .form-row .btn {
                margin-top: 25px;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <div class="header">Currency Exchange Rates</div>

            <div class="nav">
                <a href="home">Currency List</a>
                <span>Hello, ${username}</span> | 
                <a href="login">Logout</a>
            </div>

            <h3>Search Currency</h3>

            <form action="home?action=search" method="POST">
                <div class="form-row">
                    <div class="form-group">
                        <label for="code">Code:</label>
                        <input type="text" id="code" name="code" value="${code}">
                    </div>

                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" value="${name}">
                    </div>

                    <button type="submit" class="btn">Search</button>
                </div>
            </form>

            <h3>Currency List</h3>
            <table>
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Rate</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>   
                    <c:forEach items="${listCur}" var="c">
                        <tr>
                            <td>${c.getCode()}</td>
                            <td>${c.getName()}</td>
                            <td>${c.getDescription()}</td>
                            <td>${c.getRate()}</td>
                            <td>
                                <a href="#" onclick="window.location.href = 'home?action=update&code=${c.getCode()}'">Update</a>
                            </td>

                        </tr> 
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
