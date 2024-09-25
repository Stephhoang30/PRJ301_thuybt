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

        <h1>LIST OF CATEGORIES</h1>

        <form action="add" method="get">
            <input type="submit" Value="Add a new category"/>
        </form>

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

    <div>
        <form action="search" method="">
            <input type="text" name="keyword" placeholder="Search for product..."/>
            <input type="submit" value="Search"/>
        </form>

        <form action="add-product">
            <input type="submit" value="Add a new product"/>
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Release Date</th>
                    <th>Describe</th>
                    <th>Image</th>
                    <th>Category Id</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listProduct}" var="p">
                    <tr>
                        <td>${p.getId()}</td>
                        <td>${p.getName()}</td>
                        <td>${p.getQuantity()}</td>
                        <td>${p.getPrice()}</td>
                        <td>${p.getReleaseDate()}</td>
                        <td>${p.getDescribe()}</td>
                        <td>${p.getImage()}</td>
                        <td>${p.getCid()}</td>
                        <td>
                            <a href="update-product?id=${p.getId()}">Update</a>
                            <a href="#" onclick="doDeleteProduct('${p.getId().trim()}')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
</body>


<script type="text/javascript">
    function doDelete(id) {
        if (confirm("Do you want to delete category id = " + id + "?")) {
            window.location = "delete?id=" + id;
        }
    }

    function doDeleteProduct(id) {
        if (confirm("Do you want to delete product id = " + id + " ?")) {
            window.location = "delete-product?id=" + id;
        }
    }
</script>

</html>
