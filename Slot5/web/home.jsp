<%-- 
    Document   : home
    Created on : Sep 18, 2024, 11:57:37 AM
    Author     : stephhoang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
    <center>
        <h1>
            <a href="home">Category Management</a>
            <a href="product">Product Management</a>
        </h1>
        
        <h1>LIST OF CATEGORIES</h1>

        <form action="add" method="get">
            <input type="submit" Value="Add a new category"/>
        </form>

        <!-- List Category -->
        <table border="1px" width="50%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Describe</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listCategory}" var="c">
                    <tr>
                        <td>${c.getId()}</td>
                        <td>
                            <a href="product-by-category?cid=${c.getId()}">${c.getName()}</a>
                        </td>
                        <td>${c.getDescribe()}</td>
                        <td>                        
                            <a href="update?id=${c.getId()}">Update</a>
                            <a href="#" onclick="doDelete('${c.getId()}')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </center>



</body>


<script type="text/javascript">
    function doDelete(id) {
        if (confirm("Do you want to delete category id = " + id + "?")) {
            window.location = "delete?id=" + id;
        }
    }

    
</script>

</html>
