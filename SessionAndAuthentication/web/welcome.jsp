<%-- 
    Document   : welcome
    Created on : Oct 11, 2024, 9:44:43 AM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>10_HoangCongThanh</title>
        <style>
            #wrapper {
                margin: auto;
                margin-left: 10%;
                margin-right: 10%;
            }

            ul.menu {
                display: inline-block;
            }

            ul.menu li {
                margin: 10px 16px;
                float: left;
                list-style: none;
                width: 80px;
                height: 30px;
                background: chocolate;
            }

            ul.menu li a {
                text-decoration: none;
                color: white;
            }
        </style>

    </head>
    <body>
        <div id="wrapper">
            <ul class="menu">
                <c:if test="${(sessionScope.account==null)}">
                    <li><a href="login">Login</a></li>
                    <li><a href="register">Register</a></li>
                    </c:if>
                    <c:if test="${(sessionScope.account!=null)}">
                    <li><a href="logout">Logout</a></li>
                    <li><a href="#">Profile</a></li>
                    <h3> Hello ${sessionScope.account.username}</h3>
                </c:if>
            </ul>

            <h1>Home page</h1>
            <br/>
            <h2>List Student</h2>
            <c:if test="${(sessionScope.account!=null)}">
                <div style="margin-left: 11.4cm"> 
                    <a href="check?action=add">Add New Student</a>
                </div>
            </c:if>
            <table border="1" cellpadding="5" cellspacing="0">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Date of Birth</th>
                    <th>Gender</th>
                    <th>Address</th>
                        <c:if test="${(sessionScope.account!=null)}">
                        <th>Action</th>
                        </c:if>
                </tr>

                <c:forEach items="${students}" var="s">
                    <tr>
                        <td>${s.getID()}</td>
                        <td>${s.getName()}</td>
                        <td>${s.getDOB()}</td>
                        <td>${s.isGender() == true ? "Male" : "Female"}</td>
                        <td>${s.getAddress()}</td>
                        <c:if test="${(sessionScope.account!=null)}">
                            <td>
                                <a href="check?action=update&id=${s.getID()}">Update</a>
                                <a href="check?action=delete&id=${s.getID()}">Delete</a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </body>
</html>
